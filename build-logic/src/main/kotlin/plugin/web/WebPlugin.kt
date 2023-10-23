package plugin.web

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import plugin.kotlin.KotlinMultiplatformPlugin

internal class WebPlugin : Plugin<Project> {
    private val kotlinMultiplatformPlugin = KotlinMultiplatformPlugin()

    override fun apply(target: Project) {
        kotlinMultiplatformPlugin.apply(target)
        applyKotlin(target.extensions.getByType())
    }

    private fun applyKotlin(extension: KotlinMultiplatformExtension) = with(extension) {
        js(IR) {
            browser()
        }
    }
}
