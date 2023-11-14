package plugin.multiplatform

import ext.sourceSets
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import plugin.android.AndroidLibPlugin
import plugin.ios.IosPlugin
import plugin.web.WebPlugin

internal class MultiplatformPlugin : Plugin<Project> {
    private val androidLibPlugin = AndroidLibPlugin()
    private val iosPlugin = IosPlugin()
    private val webPlugin = WebPlugin()

    override fun apply(target: Project) {
        androidLibPlugin.apply(target)
        iosPlugin.apply(target)
        webPlugin.apply(target)
        applyKotlin(target.extensions.getByType())
    }

    private fun applyKotlin(extension: KotlinMultiplatformExtension) = with(extension) {
        androidTarget()
        jvm()
        applyDefaultHierarchyTemplate()
        sourceSets {
            val nonAndroidMain = maybeCreate("nonAndroidMain")

            nonAndroidMain.dependsOn(commonMain.get())
            getByName("iosTargetMain").dependsOn(nonAndroidMain)
            iosMain.get().dependsOn(nonAndroidMain)
            jvmMain.get().dependsOn(nonAndroidMain)
            jsMain.get().dependsOn(nonAndroidMain)
        }
    }
}
