package plugin.hilt

import ext.kspAndroidMain
import ext.libs
import ext.sourceSets
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import plugin.kotlin.KspPlugin

internal class HiltMultiplatformPlugin : Plugin<Project> {
    private val hiltPlugin = HiltPlugin()
    private val kspPlugin = KspPlugin()

    override fun apply(target: Project) {
        kspPlugin.apply(target)
        hiltPlugin.apply(target)
        applySourceSets(target.extensions.getByType(), target.libs)
        applyDependency(target.dependencies, target.libs)
    }

    private fun applySourceSets(extension: KotlinMultiplatformExtension, libs: VersionCatalog) = with(extension) {
        sourceSets {
            androidMain {
                dependencies {
                    implementation(libs.findLibrary("hilt-android").get())
                }
            }
        }
    }

    private fun applyDependency(handler: DependencyHandler, libs: VersionCatalog) = with(handler) {
        kspAndroidMain(libs.findLibrary("hilt-compiler").get())
    }
}
