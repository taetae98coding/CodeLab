plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    sourceSets {
        getByName("commonMain") {
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
