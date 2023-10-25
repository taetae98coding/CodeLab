plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    sourceSets {
        getByName("commonMain") {
            dependencies {
                implementation(project(":feature:webview"))
                implementation(compose.material3)
            }
        }

        getByName("androidMain") {
            dependencies {
                implementation(libs.navigation.compose)
            }
        }

        maybeCreate("nonAndroid")
        getByName("nonAndroid") {
            dependencies {

            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.app"
}
