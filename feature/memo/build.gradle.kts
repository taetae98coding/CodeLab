plugins {
    id("codelab.multiplatform")
    id("codelab.compose.android")
    alias(libs.plugins.compose.multiplatform)

    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":navigation:core"))
                implementation(project(":navigation:compose"))

                implementation(project(":domain:entity"))
                implementation(project(":domain:usecase"))

                implementation(project(":library:lifecycle-compose"))

                implementation(project(":compose"))

                implementation(compose.material3)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.navigation.compose)
                implementation(libs.hilt.compose)
                implementation(compose.uiTooling)
                implementation(libs.hilt.android)
            }
        }

        nonAndroidMain {
            dependencies {
                implementation(libs.decompose)
                implementation(libs.decompose.compose)
                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)
                implementation(libs.koin.compose)
                implementation(project.dependencies.platform(libs.koin.annotations.bom))
                implementation(libs.koin.annotations)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.feature.memo"
}

dependencies {
    kspAndroid(libs.hilt.compiler)
    kspIosMain(project.dependencies.platform(libs.koin.annotations.bom))
    kspIosMain(libs.koin.compiler)
    kspJvm(project.dependencies.platform(libs.koin.annotations.bom))
    kspJvm(libs.koin.compiler)
    kspJs(project.dependencies.platform(libs.koin.annotations.bom))
    kspJs(libs.koin.compiler)
}
