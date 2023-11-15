plugins {
    id("codelab.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.coroutines.core)
                implementation(libs.paging.common)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.paging"
}
