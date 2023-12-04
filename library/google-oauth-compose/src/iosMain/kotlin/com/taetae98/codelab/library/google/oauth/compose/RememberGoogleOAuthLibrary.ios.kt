package com.taetae98.codelab.library.google.oauth.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.interop.LocalUIViewController
import com.taetae98.codelab.library.google.oauth.GoogleOAuthLibrary

@Composable
public actual fun rememberGoogleOAuthLibrary(): GoogleOAuthLibrary {
    val uiViewController = LocalUIViewController.current

    return remember(uiViewController) { GoogleOAuthLibrary(uiViewController) }
}