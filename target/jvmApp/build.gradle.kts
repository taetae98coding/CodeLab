plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.compose.multiplatform)
}

kotlin {
    explicitApi()
    jvmToolchain(17)
}

dependencies {
    implementation(compose.desktop.currentOs)
}

compose.desktop {
    application {
        mainClass = "com.taetae98.codelab.MainKt"
    }
}