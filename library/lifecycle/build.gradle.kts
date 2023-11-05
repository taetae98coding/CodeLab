plugins {
    id("codelab.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.coroutines.core)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.lifecycle.viewmodel)
                implementation(libs.lifecycle.savedstate)
            }
        }

        nonAndroidMain {
            dependencies {
                implementation(libs.decompose)
                implementation(libs.kotlin.serialization)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.lifecycle"
}
