@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id(libs.plugins.boilerplate.android.library.asProvider().get().pluginId)
}

android {
    namespace = "io.agimaulana.github.boilerplate.infrastructure"
}

dependencies {
    implementation(libs.moshi)
    implementation(project(":core:common"))
    implementation(project(":core:network"))
    implementation(project(":domain:api"))

    ksp(libs.moshi.codegen)

    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    implementation(project(":core:network:test"))
    testImplementation(project(":core:shared-test"))
}
