plugins {
    id(libs.plugins.boilerplate.android.feature.get().pluginId)
}

android {
    namespace = "io.agimaulana.github.boilerplate.feature.sample"
}

dependencies {
    implementation(project(":domain:api"))
}
