plugins {
    id("codelab.multiplatform")
    id("codelab.koin.multiplatform")
    alias(libs.plugins.room)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":library:inject"))
                implementation(project(":data:dto"))
            }
        }

        androidMain {
            dependencies {
                implementation(libs.bundles.room)
                implementation(libs.hilt.android)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.data.local"
}

dependencies {
    kspAndroid(libs.room.compiler)
    kspAndroid(libs.hilt.compiler)
}

room {
    schemaDirectory("$projectDir/schemas/")
}
