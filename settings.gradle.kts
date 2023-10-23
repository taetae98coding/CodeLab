pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }

    includeBuild("build-logic")
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

include(":app")

include(
    ":feature:webview",
)

include(
    ":library:webview",
)
