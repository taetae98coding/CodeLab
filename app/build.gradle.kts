plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.ksp)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":navigation:core"))
                implementation(project(":feature:main"))
                implementation(project(":feature:webview"))
                implementation(project(":feature:memo"))
                implementation(project(":data:local"))
                implementation(project(":data:repository"))
                implementation(project(":domain:usecase"))

                implementation(compose.material3)
            }
        }

        androidMain {
            dependencies {
                implementation(libs.navigation.compose)
            }
        }

        nonAndroidMain {
            dependencies {
                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)
                implementation(project.dependencies.platform(libs.koin.annotations.bom))
                implementation(libs.koin.annotations)
                implementation(libs.decompose)
                implementation(libs.decompose.compose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.app"
}

dependencies {
    kspIosMain(project.dependencies.platform(libs.koin.annotations.bom))
    kspIosMain(libs.koin.compiler)
    kspJvm(project.dependencies.platform(libs.koin.annotations.bom))
    kspJvm(libs.koin.compiler)
    kspJs(project.dependencies.platform(libs.koin.annotations.bom))
    kspJs(libs.koin.compiler)
}
