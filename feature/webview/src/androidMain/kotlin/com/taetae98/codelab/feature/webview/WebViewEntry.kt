package com.taetae98.codelab.feature.webview

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.taetae98.codelab.navigation.core.webview.WebViewEntry

public fun NavGraphBuilder.webViewEntry(
    navController: NavController,
) {
    composable(WebViewEntry.ROUTE) {
        WebViewRoute(
            onNavigateUp = navController::navigateUp,
        )
    }
}
