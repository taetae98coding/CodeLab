plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        nonAndroidMain {
            dependencies {
                implementation(libs.decompose)
                implementation(libs.kotlin.serialization)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.navigation.core"
}
