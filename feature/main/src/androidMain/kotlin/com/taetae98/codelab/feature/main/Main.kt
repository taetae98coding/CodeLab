package com.taetae98.codelab.feature.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

public fun NavGraphBuilder.main(navController: NavController) {
    composable("main") {
        MainRoute(onWebView = { navController.navigate("webview") })
    }
}
