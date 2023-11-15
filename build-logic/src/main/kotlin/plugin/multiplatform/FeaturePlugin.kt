package plugin.multiplatform

import ext.libs
import ext.sourceSets
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import plugin.compose.ComposeMultiplatformPlugin
import plugin.hilt.HiltMultiplatformPlugin
import plugin.koin.KoinMultiplatformPlugin

internal class FeaturePlugin : Plugin<Project> {
    private val multiplatformPlugin = MultiplatformPlugin()
    private val composeMultiplatformPlugin = ComposeMultiplatformPlugin()
    private val hiltMultiplatformPlugin = HiltMultiplatformPlugin()
    private val koinMultiplatformPlugin = KoinMultiplatformPlugin()

    override fun apply(target: Project) {
        multiplatformPlugin.apply(target)
        composeMultiplatformPlugin.apply(target)
        hiltMultiplatformPlugin.apply(target)
        koinMultiplatformPlugin.apply(target)

        applySourceSets(target.extensions.getByType(), target.libs)
    }

    private fun applySourceSets(extension: KotlinMultiplatformExtension, libs: VersionCatalog) = with(extension) {
        sourceSets {
            commonMain {
                dependencies {
                    implementation(project(":navigation:core"))
                    implementation(project(":navigation:compose"))

                    implementation(project(":domain:entity"))
                    implementation(project(":domain:usecase"))

                    implementation(project(":library:inject-compose"))
                    implementation(project(":library:lifecycle"))
                    implementation(project(":library:lifecycle-compose"))

                    implementation(project(":compose"))

                    implementation(libs.findLibrary("kotlin-immutable").get())
                }
            }

            androidMain {
                dependencies {
                    implementation(libs.findLibrary("navigation-compose").get())
                    implementation(libs.findLibrary("hilt-compose").get())
                }
            }

            getByName("nonAndroidMain") {
                dependencies {
                    implementation(libs.findLibrary("decompose-compose").get())
                    implementation(project.dependencies.platform(libs.findLibrary("koin-bom").get()))
                    implementation(libs.findLibrary("koin-compose").get())
                }
            }
        }
    }
}