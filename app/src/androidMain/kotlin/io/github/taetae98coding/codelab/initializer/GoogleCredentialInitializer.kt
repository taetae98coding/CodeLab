package io.github.taetae98coding.codelab.initializer

import android.content.Context
import androidx.startup.Initializer
import io.github.taetae98coding.coedlab.BuildKonfig
import io.github.taetae98coding.google.credentials.GoogleCredentialsSdk

public class GoogleCredentialInitializer : Initializer<GoogleCredentialsSdk> {
    override fun create(context: Context): GoogleCredentialsSdk {
        return GoogleCredentialsSdk.serverClientId(BuildKonfig.GOOGLE_CLIENT_ID)
    }

    override fun dependencies(): List<Class<out Initializer<*>?>?> {
        return emptyList()
    }
}
