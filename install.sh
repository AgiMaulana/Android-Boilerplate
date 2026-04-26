#!/usr/bin/env bash
set -euo pipefail

DEFAULT_BRANCH="agi/install-script"
DRY_RUN=false
VERIFY=false

log(){ echo "[INFO] $1"; }
err(){ echo "[ERROR] $1"; }
run(){ [[ "$DRY_RUN" == true ]] && echo "[DRY-RUN] $*" || eval "$@"; }

cleanup(){ [[ -d "${TEMP_DIR:-}" ]] && rm -rf "$TEMP_DIR"; }
trap cleanup EXIT

PROJECT_NAME="${1:-}"
PACKAGE_NAME="${2:-}"
BRANCH="${3:-$DEFAULT_BRANCH}"

[[ -z "$PROJECT_NAME" || -z "$PACKAGE_NAME" ]] && { err "Usage: $0 <project> <package> [branch]"; exit 1; }

[[ "$PACKAGE_NAME" =~ ^[a-z]+(\.[a-z][a-z0-9_]*)+$ ]] || { err "Invalid package: $PACKAGE_NAME"; exit 1; }

[[ -d "$PROJECT_NAME" ]] && { err "Directory exists: $PROJECT_NAME"; exit 1; }

command -v git >/dev/null || { err "git required"; exit 1; }
command -v rsync >/dev/null || { err "rsync required"; exit 1; }

TEMP_DIR=$(mktemp -d)
log "Cloning template ($BRANCH)..."
run "git clone --depth=1 --branch $BRANCH https://github.com/AgiMaulana/Android-Boilerplate.git $TEMP_DIR"

log "Copying project..."
run "rsync -a --exclude='.git' $TEMP_DIR/ $PROJECT_NAME/"
cd "$PROJECT_NAME"

OLD_PACKAGE="io.github.agimaulana.boilerplate"
OLD_PATH="${OLD_PACKAGE//./\/}"
NEW_PATH="${PACKAGE_NAME//./\/}"

log "Replacing package occurrences..."
run "grep -rl '$OLD_PACKAGE' . | xargs sed -i.bak 's|$OLD_PACKAGE|$PACKAGE_NAME|g' || true"
run "find . -name '*.bak' -delete"

log "Moving source directories..."
find . -type d \( -path '*/src/*/kotlin' -o -path '*/src/*/java' \) | while read -r dir; do
  if [[ -d "$dir/$OLD_PATH" ]]; then
    run "mkdir -p \"$(dirname \"$dir/$NEW_PATH\")\""
    run "mv \"$dir/$OLD_PATH\" \"$dir/$NEW_PATH\""
  else
    log "Skip: $dir/$OLD_PATH"
  fi
done

if [[ -n "${ANDROID_SDK_ROOT:-}" ]]; then
  log "Writing local.properties"
  run "echo 'sdk.dir=$ANDROID_SDK_ROOT' > local.properties"
fi

log "Initializing git"
run "git init"

if [[ "$VERIFY" == true ]]; then
  log "Running build verification"
  run "./gradlew assembleDebug"
fi

log "Done: $PROJECT_NAME ($PACKAGE_NAME)"