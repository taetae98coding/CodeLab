plugins {
    id("codelab.multiplatform")
}

kotlin {
    sourceSets {
        getByName("androidMain") {
            dependencies {
                api(libs.java.inject)
                api(libs.hilt.android)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.inject"
}
