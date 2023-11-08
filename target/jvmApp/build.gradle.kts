plugins {
    id("codelab.jvm")
    alias(libs.plugins.compose.multiplatform)
}

dependencies {
    implementation(project(":app"))
    implementation(project(":navigation:core"))
    implementation(project(":data:sqldelight"))

    implementation(compose.desktop.currentOs)
    implementation(compose.ui)
    implementation(libs.decompose)
    implementation(libs.coroutines.swing)

    implementation(platform(libs.koin.bom))
    implementation(libs.koin.core)
}

compose.desktop {
    application {
        mainClass = "com.taetae98.codelab.MainKt"
    }
}
