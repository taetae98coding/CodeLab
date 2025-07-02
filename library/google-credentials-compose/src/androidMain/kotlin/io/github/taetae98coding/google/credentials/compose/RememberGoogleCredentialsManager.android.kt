package io.github.taetae98coding.google.credentials.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import io.github.taetae98coding.google.credentials.GoogleCredentialsManager
import io.github.taetae98coding.google.credentials.GoogleCredentialsManagerImpl

@Composable
public actual fun rememberGoogleCredentialsManager(): GoogleCredentialsManager {
    val context = LocalContext.current

    return remember(context) {
        GoogleCredentialsManagerImpl(context)
    }
}
