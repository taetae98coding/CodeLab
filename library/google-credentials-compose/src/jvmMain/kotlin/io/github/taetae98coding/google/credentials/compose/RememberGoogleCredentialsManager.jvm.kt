package io.github.taetae98coding.google.credentials.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import io.github.taetae98coding.google.credentials.GoogleCredentialManagerImpl
import io.github.taetae98coding.google.credentials.GoogleCredentialsManager

@Composable
public actual fun rememberGoogleCredentialsManager(): GoogleCredentialsManager {
    return remember { GoogleCredentialManagerImpl() }
}
