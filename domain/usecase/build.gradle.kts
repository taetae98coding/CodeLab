plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.ksp)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":domain:entity"))
                implementation(project(":domain:exception"))
                implementation(project(":domain:repository"))
                implementation(project(":library:inject"))

                implementation(project.dependencies.platform(libs.koin.annotations.bom))
                implementation(libs.koin.annotations)
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
    namespace = "${Build.NAMESPACE}.domain.usecase"
}

dependencies {
    kspIosMain(project.dependencies.platform(libs.koin.annotations.bom))
    kspIosMain(libs.koin.compiler)
    kspJvm(project.dependencies.platform(libs.koin.annotations.bom))
    kspJvm(libs.koin.compiler)
    kspJs(project.dependencies.platform(libs.koin.annotations.bom))
    kspJs(libs.koin.compiler)
}
