plugins {
    id("codelab.multiplatform")
    id("codelab.compose.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":library:inject-compose"))
                implementation(project(":library:lifecycle"))
                implementation(project(":navigation:core"))
                implementation(compose.runtime)
            }
        }
        
        androidMain {
            dependencies {
                implementation(libs.navigation.compose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.navigation.compose"
}
