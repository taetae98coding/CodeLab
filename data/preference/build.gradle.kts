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
    }
}

android {
    namespace = "${Build.NAMESPACE}.data.preference"
}
