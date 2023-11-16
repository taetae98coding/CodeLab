package plugin.compose

import ext.compose
import ext.sourceSets
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.PluginManager
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

internal class ComposeMultiplatformPlugin : Plugin<Project> {
    private val composeAndroidPlugin = ComposeAndroidPlugin()
    override fun apply(target: Project) {
        composeAndroidPlugin.apply(target)

        applyPlugin(target.pluginManager)
        applySourceSets(target.extensions.getByType())
    }

    private fun applyPlugin(manager: PluginManager) = with(manager) {
        apply("org.jetbrains.compose")
    }

    private fun applySourceSets(extension: KotlinMultiplatformExtension) = with(extension) {
        sourceSets {
            androidMain {
                dependencies {
                    compileOnly(compose.uiTooling)
                }
            }
        }
    }
}