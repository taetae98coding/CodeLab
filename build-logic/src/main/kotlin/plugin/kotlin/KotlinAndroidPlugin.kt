package plugin.kotlin

import Build
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

internal class KotlinAndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        applyPlugin(target.pluginManager)
        applyKotlin(target.extensions.getByType())
    }

    private fun applyPlugin(manager: PluginManager) = with(manager) {
        apply("org.jetbrains.kotlin.android")
    }

    private fun applyKotlin(extension: KotlinAndroidProjectExtension) = with(extension) {
        explicitApi()
        jvmToolchain(Build.JAVA_VERSION)
    }
}
