package com.taetae98.codelab.library.google.oauth.compose

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import com.taetae98.codelab.library.google.oauth.GoogleOAuthLibrary

@Composable
public actual fun rememberGoogleOAuthLibrary(): GoogleOAuthLibrary {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val oneTapLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartIntentSenderForResult(),
        onResult = {
        },
    )
    val googleLoginLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult(),
        onResult = {
        },
    )

    return remember {
        GoogleOAuthLibrary(
            context = context,
            coroutineScope = coroutineScope,
            oneTapLoginLauncher = oneTapLauncher,
            googleLoginLauncher = googleLoginLauncher,
        )
    }
}