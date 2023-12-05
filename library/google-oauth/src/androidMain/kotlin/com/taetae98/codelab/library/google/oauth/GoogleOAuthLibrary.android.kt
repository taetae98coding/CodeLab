package com.taetae98.codelab.library.google.oauth

import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.IntentSenderRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.Identity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

public actual class GoogleOAuthLibrary(
    private val context: Context,
    private val coroutineScope: CoroutineScope,
    private val oneTapLoginLauncher: ActivityResultLauncher<IntentSenderRequest>,
    private val googleLoginLauncher: ActivityResultLauncher<Intent>,
) {
    public actual fun signIn() {
        coroutineScope.launch {
            try {
                oneTapLogin()
            } catch (e: Exception) {
                googleLogin()
            }
        }
    }

    private suspend fun oneTapLogin() {
        val request = BeginSignInRequest.builder()
            .setGoogleIdTokenRequestOptions(
                BeginSignInRequest.GoogleIdTokenRequestOptions.builder()
                    .setSupported(true)
                    .setFilterByAuthorizedAccounts(false)
                    .setServerClientId(BuildConfig.GOOGLE_SERVER_CLIENT_ID)
                    .build(),
            )
            .setAutoSelectEnabled(false)
            .build()

        val result = Identity.getSignInClient(context).beginSignIn(request).await()

        oneTapLoginLauncher.launch(IntentSenderRequest.Builder(result.pendingIntent).build())
    }

    private fun googleLogin() {
        val client = GoogleSignIn.getClient(
            context,
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(BuildConfig.GOOGLE_SERVER_CLIENT_ID)
                .build(),
        )

        client.signOut()
        googleLoginLauncher.launch(client.signInIntent)
    }

    public actual fun signOut() {
        GoogleSignIn.getClient(context, GoogleSignInOptions.DEFAULT_SIGN_IN).signOut()
    }
}