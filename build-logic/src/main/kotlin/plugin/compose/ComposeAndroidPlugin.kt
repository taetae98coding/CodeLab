package plugin.compose

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

internal class ComposeAndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        applyAndroid(target.extensions.getByType(CommonExtension::class))
    }

    private fun applyAndroid(extension: CommonExtension<*, *, *, *, *>) = with(extension) {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = "1.5.3"
        }
    }
}
