package plugin.android

import Build
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.getByType
import plugin.kotlin.KotlinAndroidPlugin

internal class AndroidAppPlugin : Plugin<Project> {
    private val kotlinAndroidPlugin = KotlinAndroidPlugin()
    private val androidPlugin = AndroidPlugin()

    override fun apply(target: Project) {
        applyPlugin(target.pluginManager)
        applyAndroid(target.extensions.getByType())
        androidPlugin.apply(target)
        kotlinAndroidPlugin.apply(target)
    }

    private fun applyPlugin(manager: PluginManager) = with(manager) {
        apply("com.android.application")
    }

    private fun applyAndroid(extension: ApplicationExtension) = with(extension) {
        defaultConfig {
            targetSdk = Build.TARGET_SDK
        }
    }
}
