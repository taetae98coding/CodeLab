package com.taetae98.codelab.feature.google.oauth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.taetae98.codelab.navigation.core.google.oauth.GoogleOAuthEntry

public fun NavGraphBuilder.googleOAuthEntry(
    navController: NavController,
) {
    composable(
        route = GoogleOAuthEntry.ROUTE
    ) {
        GoogleOAuthRoute(onNavigateUp = navController::navigateUp)
    }
}