plugins {
    id("codelab.multiplatform")
    id("codelab.koin.multiplatform")
    alias(libs.plugins.sqldelight)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":data:dto"))
                implementation(project(":data:local"))

                implementation(libs.sqldelight.paging)
                implementation(libs.coroutines.core)
                implementation(libs.paging.common)
            }
        }

        iosMain {
            dependencies {
                implementation("co.touchlab:stately-iso-collections:2.0.5")
                implementation(libs.sqldelight.native.driver)
            }
        }

        jvmMain {
            dependencies {
                implementation(libs.sqldelight.sqlite.driver)
            }
        }

        jsMain {
            dependencies {
                implementation("co.touchlab:stately-iso-collections:2.0.5")
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.data.sqldelight"
}

sqldelight {
    databases {
        create("MemoDatabase") {
            packageName.set("${Build.NAMESPACE}.data.sqldelight")

            dialect(libs.sqldelight.dialect)
            srcDirs("$projectDir/src/nonAndroidMain/memo")
        }
    }
}
