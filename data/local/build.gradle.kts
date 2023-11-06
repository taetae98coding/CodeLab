plugins {
    id("codelab.multiplatform")
    id("codelab.koin.multiplatform")
    id("codelab.hilt.multiplatform")
    alias(libs.plugins.room)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.ksp)
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(project(":library:inject"))
                implementation(project(":data:dto"))
            }
        }

        androidMain {
            dependencies {
                implementation(libs.bundles.room)
            }
        }

        jvmMain {
            dependencies {
                implementation(libs.sqldelight.sqlite.driver)
            }
        }

        jsMain {
            dependencies {
                implementation("app.cash.sqldelight:web-worker-driver:2.0.0")
                implementation(devNpm("copy-webpack-plugin", "9.1.0"))
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.data.local"
}

dependencies {
    kspAndroid(libs.room.compiler)
}

room {
    schemaDirectory("$projectDir/room/schemas/")
}

sqldelight {
    databases {
        create("MemoDatabase") {
            packageName.set("${Build.NAMESPACE}.core.database")
            verifyMigrations.set(true)
            schemaOutputDirectory.set(file("$projectDir/sqldelight/schemas"))
            generateAsync.set(true)

            dialect(libs.sqldelight.dialect)
            srcDirs("src/nonAndroidMain/memo")
        }
    }
}
