plugins {
    id("codelab.multiplatform")
}

kotlin {
    sourceSets {
        getByName("commonMain") {
            dependencies {
                implementation(project(":library:inject"))
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.domain.usecase"
}
