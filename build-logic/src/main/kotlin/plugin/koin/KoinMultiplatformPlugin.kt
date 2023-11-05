package plugin.koin

import ext.kspNonAndroidMain
import ext.libs
import ext.sourceSets
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import plugin.kotlin.KspPlugin

internal class KoinMultiplatformPlugin : Plugin<Project> {
    private val kspPlugin = KspPlugin()

    override fun apply(target: Project) {
        kspPlugin.apply(target)
        applySourceSets(target.extensions.getByType(), target.libs)
        applyDependency(target.dependencies, target.libs)
    }

    private fun applySourceSets(extension: KotlinMultiplatformExtension, libs: VersionCatalog) = with(extension) {
        sourceSets {
            commonMain {
                dependencies {
                    implementation(project.dependencies.platform(libs.findLibrary("koin-annotations-bom").get()))
                    implementation(libs.findLibrary("koin-annotations").get())
                }
            }

            getByName("nonAndroidMain") {
                dependencies {
                    implementation(project.dependencies.platform(libs.findLibrary("koin-bom").get()))
                    implementation(libs.findLibrary("koin-core").get())
                }
            }
        }
    }

    private fun applyDependency(handler: DependencyHandler, libs: VersionCatalog) = with(handler) {
        kspNonAndroidMain(platform(libs.findLibrary("koin-annotations-bom").get()))
        kspNonAndroidMain(libs.findLibrary("koin-compiler").get())
    }
}