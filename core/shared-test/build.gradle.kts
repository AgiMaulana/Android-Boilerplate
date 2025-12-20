plugins {
    id(libs.plugins.boilerplate.android.library.asProvider().get().pluginId)
}

android {
    namespace = "io.agimaulana.github.boilerplate.core.sharedtest"
}

dependencies {
    implementation(libs.kotlinx.coroutines.test)
    implementation(project(":core:common"))
}
