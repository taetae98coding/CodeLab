package io.github.taetae98coding.codelab

import androidx.compose.ui.window.singleWindowApplication
import io.github.taetae98coding.coedlab.BuildKonfig
import io.github.taetae98coding.google.credentials.GoogleCredentialsSdk

public fun main() {
    GoogleCredentialsSdk.redirectUri(BuildKonfig.GOOGLE_REDIRECT_URI)
        .clientId(BuildKonfig.GOOGLE_CLIENT_ID)
        .clientSecret(BuildKonfig.GOOGLE_CLIENT_SECRET)

    singleWindowApplication {
        App()
    }
}
