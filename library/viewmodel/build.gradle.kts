plugins {
    id("codelab.multiplatform")
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
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.viewmodel"
}
