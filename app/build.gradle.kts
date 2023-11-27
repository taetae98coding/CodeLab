plugins {
    id("codelab.multiplatform")
    id("codelab.koin.multiplatform")
    id("codelab.compose.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":navigation:core"))

                implementation(project(":feature:main"))
                implementation(project(":feature:webview"))
                implementation(project(":feature:memo"))
                implementation(project(":feature:poke"))
                implementation(project(":feature:datastore"))

                implementation(compose.material3)
            }
        }

        androidMain {
            dependencies {
                runtimeOnly(project(":data:repository"))
                runtimeOnly(project(":data:datastore"))
                runtimeOnly(project(":data:room"))

                implementation(libs.navigation.compose)
            }
        }

        nonAndroidMain {
            dependencies {
                implementation(project(":data:datastore"))
                implementation(project(":data:sqldelight"))
                implementation(project(":data:remote"))
                implementation(project(":data:repository"))
                implementation(project(":domain:usecase"))

                implementation(libs.decompose)
                implementation(libs.decompose.compose)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.app"
}
