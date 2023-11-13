plugins {
    id("codelab.feature")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.material3)
                implementation(libs.paging.compose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.memo"
}
