plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        getByName("commonMain") {
            dependencies {
                implementation(libs.decompose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.navigation.core"
}
