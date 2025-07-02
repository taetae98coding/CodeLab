pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com.android.*")
                includeGroupByRegex("com.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("https://androidx.dev/snapshots/builds/13729941/artifacts/repository")
            content {
                includeGroupByRegex("androidx.*")
            }
        }
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com.android.*")
                includeGroupByRegex("com.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        maven {
            url = uri("https://androidx.dev/snapshots/builds/13729941/artifacts/repository")
            content {
                includeGroupByRegex("androidx.*")
            }
        }
    }
}

rootProject.name = "CodeLab"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")
include(":compose")
include(":core:navigation")
include(":feature:auth")
include(":feature:home")
include(":library:google-credentials")
include(":library:google-credentials-compose")
