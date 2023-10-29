plugins {
    id("codelab.android.app")
    id("codelab.compose.android")
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt.android)
}

android {
    namespace = Build.NAMESPACE

    defaultConfig {
        applicationId = Build.NAMESPACE
        versionCode = 10000
        versionName = "1.0.0"
    }
}

dependencies {
    implementation(project(":app"))

    implementation(project(":navigation:core"))
    implementation(libs.decompose)

    implementation(libs.material)
    implementation(libs.activity.compose)

    implementation(platform(libs.compose.bom))
    implementation(libs.compose.ui)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}

kapt {
    correctErrorTypes = true
}
