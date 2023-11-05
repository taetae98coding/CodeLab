package plugin.hilt

import ext.implementation
import ext.ksp
import ext.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.dsl.DependencyHandler

internal class HiltAndroidPlugin : Plugin<Project> {
    private val hiltPlugin = HiltPlugin()

    override fun apply(target: Project) {
        hiltPlugin.apply(target)
        applyDependency(target.dependencies, target.libs)
    }

    private fun applyDependency(handler: DependencyHandler, libs: VersionCatalog) = with(handler) {
        implementation(libs.findLibrary("hilt-android").get())
        ksp(libs.findLibrary("hilt-compiler").get())
    }
}