plugins {
    id("codelab.multiplatform")
}

kotlin {
    sourceSets {
        getByName("androidMain") {
            dependencies {
                api(libs.java.inject)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.inject"
}
