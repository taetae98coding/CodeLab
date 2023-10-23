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
        val isPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
        val iosTarget: (String) -> KotlinNativeTarget = if (isPhone) ::iosArm64 else ::iosSimulatorArm64

        iosTarget("ios")
    }
}
