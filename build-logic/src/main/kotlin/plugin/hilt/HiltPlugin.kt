package plugin.hilt

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import plugin.kotlin.KspPlugin

internal class HiltPlugin : Plugin<Project> {
    private val kspPlugin = KspPlugin()

    override fun apply(target: Project) {
        kspPlugin.apply(target)
        applyPlugin(target.pluginManager)
    }

    private fun applyPlugin(manager: PluginManager) = with(manager) {
        apply("com.google.dagger.hilt.android")
    }
}