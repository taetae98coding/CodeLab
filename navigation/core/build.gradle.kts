plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {
    sourceSets {
        getByName("commonMain") {
            dependencies {
                implementation(libs.decompose)
                implementation(libs.coroutines.core)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.navigation.core"
}
