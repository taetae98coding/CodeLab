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
    }
}

rootProject.name = "CodeLab"

include(":app:target:jvm")
include(":app:target:common")

include(":app:core:navigation")
include(":app:core:poke-service")

include(":app:data:poke")

include(":app:domain:poke")

include(":app:feature:poke")

include(":library:paging-common")
include(":library:paging-compose")
