plugins {
    id("codelab.feature")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.material3)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.main"
}
