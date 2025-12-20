plugins {
    id(libs.plugins.boilerplate.android.library.asProvider().get().pluginId)
}

android {
    namespace = "io.agimaulana.github.boilerplate.core.shared"
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter.moshi)
}
