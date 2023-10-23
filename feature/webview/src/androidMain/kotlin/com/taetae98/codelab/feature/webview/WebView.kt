package com.taetae98.codelab.feature.webview

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

public fun NavGraphBuilder.webView(navController: NavController) {
    composable("webview") {
        WebViewRoute()
    }
}
