import com.codingfeline.buildkonfig.compiler.FieldSpec
import org.jetbrains.compose.internal.utils.getLocalProperty

plugins {
    id("codelab.multiplatform")
    alias(libs.plugins.kotlin.cocoapods)
    alias(libs.plugins.buildkonfig)
}

kotlin {
    cocoapods {
        summary = "Kotlin sample project with CocoaPods dependencies"
        homepage = "https://github.com/Kotlin/kotlin-with-cocoapods-sample"
        version = "1.0.0"
        ios.deploymentTarget = "17.0"

        pod("GoogleSignIn")
    }

    sourceSets {
        androidMain {
            dependencies {
                implementation(libs.activity.ktx)
                implementation(libs.google.auth)
                implementation(libs.coroutines.google)
            }
        }
    }
}

android {
    namespace = "${Build.NAMESPACE}.library.google.oauth"

    defaultConfig {
        buildConfigField(
            type = "String",
            name = "GOOGLE_SERVER_CLIENT_ID",
            value = "\"${getLocalProperty("google.server.client.id")!!}\"",
        )
    }

    buildFeatures {
        buildConfig = true
    }
}

buildkonfig {
    packageName = "${Build.NAMESPACE}.library.google.oauth"

    defaultConfigs {

    }

    targetConfigs {
        create("ios") {
            buildConfigField(
                type = FieldSpec.Type.STRING,
                name = "GOOGLE_CLIENT_ID",
                value = getLocalProperty("google.ios.client.id"),
                const = true
            )

            buildConfigField(
                type = FieldSpec.Type.STRING,
                name = "GOOGLE_SERVER_CLIENT_ID",
                value = getLocalProperty("google.server.client.id"),
                const = true
            )
        }
    }
}