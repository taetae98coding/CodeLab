plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.ksp)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":library:inject"))
                implementation(project(":data:dto"))
                implementation(project(":data:local"))
                implementation(project(":domain:entity"))
                implementation(project(":domain:repository"))

                implementation(project.dependencies.platform(libs.koin.annotations.bom))
                implementation(libs.koin.annotations)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.hilt.android)
            }
        }

        nonAndroidMain {
            dependencies {
                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.data.repository"
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