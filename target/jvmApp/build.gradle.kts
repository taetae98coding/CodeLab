plugins {
    id("codelab.jvm")
    alias(libs.plugins.compose.multiplatform)
}

dependencies {
    implementation(project(":app"))
    implementation(compose.desktop.currentOs)
    implementation(compose.foundation)
}

compose.desktop {
    application {
        mainClass = "com.taetae98.codelab.MainKt"
    }
}
