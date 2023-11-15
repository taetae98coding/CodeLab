plugins {
    id("codelab.feature")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":library:paging"))
                implementation(project(":library:paging-compose"))
                implementation(project(":library:image"))
                implementation(compose.material3)
                implementation(libs.paging.compose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.poke"
}
