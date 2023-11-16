plugins {
    id("codelab.multiplatform")
    id("codelab.koin.multiplatform")
    alias(libs.plugins.sqldelight)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":data:local"))

                implementation(project(":data:dto"))

                implementation(libs.sqldelight.paging)
                implementation(libs.coroutines.core)
            }
        }

        iosMain {
            dependencies {
                implementation(libs.stately.collections)
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
                implementation(libs.stately.collections)
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
