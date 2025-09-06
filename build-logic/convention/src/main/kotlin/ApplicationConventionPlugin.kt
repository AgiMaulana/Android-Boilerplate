import com.android.build.api.dsl.ApplicationExtension
import com.pajk.idpersonaldoc.configureAndroid
import com.pajk.idpersonaldoc.configureEnv
import com.pajk.idpersonaldoc.configureView
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class ApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            with(pluginManager) {
                apply("radio247fm.android.hilt")
                apply("radio247fm.kotlin.detekt")
                apply("radio247fm.android.application.jacoco")
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<ApplicationExtension> {
                configureAndroid(this)
                configureEnv(this)
                defaultConfig.targetSdk = libs.findVersion("targetSdk").get().toString().toInt()
            }

            dependencies {
                add("implementation", libs.findLibrary("compose.lifecycle.runtime").get())
                add("implementation", libs.findLibrary("kotlinx.coroutines.core").get())
                add("implementation", libs.findLibrary("compose.lifecycle.runtime").get())
                add("implementation", libs.findLibrary("androidx.core").get())
                add("implementation", libs.findLibrary("androidx.appcompat").get())
                add("implementation", project(":core:plank:plank"))

                add("testImplementation", project(":core:shared-test"))
                add("testImplementation", libs.findLibrary("turbin.test").get())
                add("testImplementation", libs.findLibrary("mockito.core").get())
                add("testImplementation", libs.findLibrary("kotlinx.coroutinesTest").get())
                add("testImplementation", libs.findLibrary("mockk.test").get())
                add("testImplementation", libs.findLibrary("androidx.lifecycle.runtime.test").get())

                add("lintChecks", project(":core:plank:lint"))
            }
        }
    }
}
