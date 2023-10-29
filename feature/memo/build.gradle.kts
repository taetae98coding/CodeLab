plugins {
    id("codelab.multiplatform")
    id("codelab.compose.android")
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    sourceSets {
        getByName("commonMain") {
            dependencies {
                implementation(project(":navigation:core"))
                implementation(compose.material3)
            }
        }

        getByName("androidMain") {
            dependencies {
                implementation(compose.uiTooling)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.memo"
}
