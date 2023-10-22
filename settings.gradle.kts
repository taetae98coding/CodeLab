pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()

        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

rootProject.name = "CodeLab"
include(
    ":target:androidApp",
    ":target:iosApp",
    ":target:jvmApp",
    ":target:webApp",
)
