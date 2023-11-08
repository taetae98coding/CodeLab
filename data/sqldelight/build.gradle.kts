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
            }
        }

        iosMain {
            dependencies {
                implementation(libs.sqldelight.native.driver)
            }
        }

        jvmMain {
            dependencies {
                implementation(libs.sqldelight.sqlite.driver)
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
            schemaOutputDirectory.set(file("src/main/memo/scheme"))
            verifyMigrations.set(true)

            dialect(libs.sqldelight.dialect)
            srcDirs("$projectDir/src/nonAndroidMain/memo")
        }
    }
}
