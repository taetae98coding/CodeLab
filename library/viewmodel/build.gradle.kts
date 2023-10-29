plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        getByName("commonMain") {
            dependencies {
                implementation(libs.coroutines.core)
            }
        }

        getByName("nonAndroidMain") {
            dependencies {
                implementation(libs.decompose)
                implementation(libs.kotlin.serialization)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.viewmodel"
}
