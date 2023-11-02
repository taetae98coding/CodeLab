package plugin.ios

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import plugin.kotlin.KotlinMultiplatformPlugin

internal class IosPlugin : Plugin<Project> {
    private val kotlinMultiplatformPlugin = KotlinMultiplatformPlugin()

    override fun apply(target: Project) {
        kotlinMultiplatformPlugin.apply(target)
        applyKotlin(target.extensions.getByType())
    }

    private fun applyKotlin(extension: KotlinMultiplatformExtension) = with(extension) {
        iosArm64()
        iosSimulatorArm64()

        applyDefaultHierarchyTemplate()
    }
}
