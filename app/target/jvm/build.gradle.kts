plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose)
    alias(libs.plugins.compose.compiler)
}

kotlin {
    explicitApi()
    jvmToolchain(17)

    jvm()

    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":app:target:common"))

                implementation(project.dependencies.platform(libs.koin.bom))
                implementation(libs.koin.core)

                implementation(compose.desktop.currentOs)

                runtimeOnly(libs.ktor.client.okhttp)
                runtimeOnly(libs.kotlinx.coroutines.swing)
            }
        }
    }
}
