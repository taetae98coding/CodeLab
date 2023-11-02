plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.compose.multiplatform)
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
