package plugin.android

import org.gradle.api.Plugin
import org.gradle.api.Project
import plugin.kotlin.KotlinAndroidPlugin

internal class AndroidLibraryPlugin : Plugin<Project> {
    private val androidLibPlugin = AndroidLibPlugin()
    private val kotlinAndroidPlugin = KotlinAndroidPlugin()

    override fun apply(target: Project) {
        androidLibPlugin.apply(target)
        kotlinAndroidPlugin.apply(target)
    }
}