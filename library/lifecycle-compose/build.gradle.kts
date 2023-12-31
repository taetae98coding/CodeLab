plugins {
    id("codelab.multiplatform")
    id("codelab.compose.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.runtime)
                implementation(libs.coroutines.core)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.lifecycle.compose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.lifecycle.compose"
}
