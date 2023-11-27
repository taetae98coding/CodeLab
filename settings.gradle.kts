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
    ":navigation:core",
    ":navigation:compose",
)

include(
    ":data:dto",
    ":data:repository",
    ":data:preference",
    ":data:local",
    ":data:remote",
    ":data:datastore",
    ":data:room",
    ":data:sqldelight",
)

include(
    ":domain:entity",
    ":domain:exception",
    ":domain:repository",
    ":domain:usecase",
)

include(
    ":feature:main",
    ":feature:webview",
    ":feature:memo",
    ":feature:poke",
    ":feature:datastore",
)

include(":compose")

include(
    ":library:inject",
    ":library:inject-compose",
    ":library:lifecycle",
    ":library:lifecycle-compose",
    ":library:webview",
    ":library:image",
    ":library:paging",
    ":library:paging-compose",
)
