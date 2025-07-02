package io.github.taetae98coding.google.credentials.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import io.github.taetae98coding.google.credentials.GoogleCredentialsManager
import io.github.taetae98coding.google.credentials.exception.GoogleCredentialsUnsupportedException

@Composable
public actual fun rememberGoogleCredentialsManager(): GoogleCredentialsManager {
    return remember {
        object : GoogleCredentialsManager {
            override suspend fun getIdToken(): String {
                throw GoogleCredentialsUnsupportedException()
            }
        }
    }
}
