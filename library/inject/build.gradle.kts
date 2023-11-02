plugins {
    id("codelab.multiplatform")
}

kotlin {
    sourceSets {
        androidMain {
            dependencies {
                api(libs.java.inject)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.inject"
}
