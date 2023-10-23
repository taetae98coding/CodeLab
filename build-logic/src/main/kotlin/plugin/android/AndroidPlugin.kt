package plugin.android

import Build
import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

internal class AndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        applyAndroid(target.extensions.getByType(CommonExtension::class))
    }

    private fun applyAndroid(extension: CommonExtension<*, *, *, *, *>) = with(extension) {
        compileSdk = Build.COMPILE_SDK
        defaultConfig {
            minSdk = Build.MIN_SDK
        }
    }
}
