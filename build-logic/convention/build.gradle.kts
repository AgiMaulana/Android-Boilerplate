plugins {
    `kotlin-dsl`
}

group = "io.agimaulana.github.boilerplate.buildlogic"

java {
    sourceCompatibility = JavaVersion.valueOf(libs.versions.jdk.get())
    targetCompatibility = JavaVersion.valueOf(libs.versions.jdk.get())
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.radio247fm.android.application.asProvider().get().pluginId
            implementationClass = "ApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = libs.plugins.radio247fm.android.library.get().pluginId
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("javaLibrary") {
            id = libs.plugins.radio247fm.java.library.get().pluginId
            implementationClass = "JavaLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = libs.plugins.radio247fm.android.feature.get().pluginId
            implementationClass = "FeatureConventionPlugin"
        }
        register("androidHilt") {
            id = libs.plugins.radio247fm.android.hilt.get().pluginId
            implementationClass = "HiltConventionPlugin"
        }
        register("kotlinDetekt") {
            id = libs.plugins.radio247fm.kotlin.detekt.get().pluginId
            implementationClass = "DetektConventionPlugin"
        }
        register("androidApplicationJacoco") {
            id = libs.plugins.radio247fm.android.application.jacoco.get().pluginId
            implementationClass = "AndroidApplicationJacocoConventionPlugin"
        }
    }
}
