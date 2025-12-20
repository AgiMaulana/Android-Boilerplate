package io.agimaulana.github.boilerplate.core.common

import java.time.LocalDateTime
import java.time.ZoneId

interface DateTimeProvider {
    fun now(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime
}
