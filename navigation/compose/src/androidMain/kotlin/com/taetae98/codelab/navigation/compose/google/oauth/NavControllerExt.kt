package com.taetae98.codelab.navigation.compose.google.oauth

import androidx.navigation.NavController
import com.taetae98.codelab.navigation.core.google.oauth.GoogleOAuthEntry

public fun NavController.navigateToGoogleOAuth() {
    navigate(GoogleOAuthEntry.ROUTE)
}