package io.github.taetae98coding.google.credentials

import android.content.Context
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.GetCredentialCancellationException
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import io.github.taetae98coding.google.credentials.exception.GoogleCredentialCancellationException
import io.github.taetae98coding.google.credentials.exception.GoogleCredentialException

public class GoogleCredentialsManagerImpl(
    private val context: Context,
) : GoogleCredentialsManager {
    override suspend fun getIdToken(options: GoogleCredentialsOptions): String {
        return try {
            val credentialsManager = CredentialManager.Companion.create(context)
            val googleIdOption = GetGoogleIdOption.Builder()
                .setFilterByAuthorizedAccounts(options.filterByAuthorizedAccounts)
                .setServerClientId(GoogleCredentialsSdk.getServerClientId())
                .setAutoSelectEnabled(options.autoSelectEnabled)
                .setNonce(options.nonce)
                .build()

            val request = GetCredentialRequest.Builder()
                .addCredentialOption(googleIdOption)
                .build()

            val result = credentialsManager.getCredential(context, request)
            val googleIdTokenCredential = GoogleIdTokenCredential.Companion.createFrom(result.credential.data)

            googleIdTokenCredential.idToken
        } catch (e: GetCredentialCancellationException) {
            throw GoogleCredentialCancellationException(cause = e)
        } catch (throwable: Throwable) {
            throw GoogleCredentialException(cause = throwable)
        }
    }
}
