package plugin.kotlin

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager

internal class KspPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        applyPlugin(target.pluginManager)
    }

    private fun applyPlugin(manager: PluginManager) = with(manager) {
        apply("com.google.devtools.ksp")
    }
}