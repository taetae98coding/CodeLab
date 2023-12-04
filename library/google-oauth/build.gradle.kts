plugins {
    id("codelab.multiplatform")
    id("codelab.compose.multiplatform")
    alias(libs.plugins.kotlin.cocoapods)
}

kotlin {
    cocoapods {
        summary = "Kotlin sample project with CocoaPods dependencies"
        homepage = "https://github.com/Kotlin/kotlin-with-cocoapods-sample"
        version = "1.0.0"
        ios.deploymentTarget = "17.0"

        pod("GoogleSignIn")
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.ui)
            }
        }
    }
}

android {
    namespace = "com.taetae98.codelab.library.google.oauth"
}