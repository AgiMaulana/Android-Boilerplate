package com.pajk.idpersonaldoc

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

internal fun Project.configureEnv(
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    commonExtension.apply {
        flavorDimensions += "env"
        productFlavors {
            register("dev") {
            }
            register("staging") {
            }
            register("prod") {
            }
        }
    }
}
