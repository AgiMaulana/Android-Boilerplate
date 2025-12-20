plugins {
    id(libs.plugins.boilerplate.java.library.get().pluginId)
}

dependencies {
    implementation(libs.junit)
    implementation(libs.retrofit)
    implementation(libs.okhttp.mockwebserver)
}
