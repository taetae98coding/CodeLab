plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                implementation(libs.navigation.common)
            }
        }

        nonAndroidMain {
            dependencies {
                api(libs.decompose)
                implementation(libs.kotlin.serialization)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.navigation.core"
}
