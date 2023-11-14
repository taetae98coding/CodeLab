plugins {
    id("codelab.multiplatform")
    id("codelab.compose.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.compose"
}
