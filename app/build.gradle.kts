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
                implementation(project(":feature:main"))
                implementation(project(":feature:webview"))
                implementation(project(":feature:memo"))
                implementation(project(":data:local"))
                implementation(project(":data:repository"))
                implementation(project(":domain:usecase"))

                implementation(compose.material3)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.navigation.compose)
            }
        }

        nonAndroidMain {
            dependencies {
                implementation(libs.decompose)
                implementation(libs.decompose.compose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.app"
}
