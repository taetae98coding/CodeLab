package com.taetae98.codelab.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.taetae98.codelab.feature.webview.webView

@Composable
public fun AppRoute(modifier: Modifier = Modifier) {
    CodeLabTheme {
        val navController = rememberNavController()

        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = "webview",
        ) {
            webView(navController = navController)
        }
    }
}
