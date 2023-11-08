plugins {
    id("codelab.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":data:dto"))
                implementation(libs.coroutines.core)
                implementation(libs.paging.common)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.data.local"
}
