plugins {
    id("codelab.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.paging.compose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.paging.compose"
}
