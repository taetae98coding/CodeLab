plugins {
    id("codelab.multiplatform")
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

        nonAndroidMain {
            dependencies {
                implementation(project.dependencies.platform(libs.koin.annotations.bom))
                implementation(libs.koin.annotations)
                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)
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
    kspIosMain(project.dependencies.platform(libs.koin.annotations.bom))
    kspIosMain(libs.koin.compiler)
    kspJvm(project.dependencies.platform(libs.koin.annotations.bom))
    kspJvm(libs.koin.compiler)
    kspJs(project.dependencies.platform(libs.koin.annotations.bom))
    kspJs(libs.koin.compiler)
}

room {
    schemaDirectory("$projectDir/schemas/")
}
