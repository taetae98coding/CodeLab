plugins {
    id("codelab.multiplatform")
    id("codelab.compose.android")
    id("codelab.hilt.multiplatform")
    id("codelab.koin.multiplatform")

    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":navigation:core"))
                implementation(project(":navigation:compose"))

                implementation(project(":domain:entity"))
                implementation(project(":domain:usecase"))

                implementation(project(":library:inject-compose"))
                implementation(project(":library:lifecycle"))
                implementation(project(":library:lifecycle-compose"))

                implementation(project(":compose"))

                implementation(compose.material3)
                implementation(libs.paging.compose)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.navigation.compose)
                implementation(libs.hilt.compose)
                implementation(compose.uiTooling)
            }
        }

        nonAndroidMain {
            dependencies {
                implementation(libs.bundles.decompose)
                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.compose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.memo"
}
