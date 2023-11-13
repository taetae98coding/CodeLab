plugins {
    id("codelab.feature")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.immutable)
                implementation(compose.material3)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.main"
}
