plugins {
    id("codelab.multiplatform")
    id("codelab.koin.multiplatform")

    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":navigation:core"))
                implementation(compose.material3)
            }
        }

        nonAndroidMain {
            dependencies {
                implementation(libs.bundles.decompose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.poke"
}
