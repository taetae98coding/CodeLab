package com.taetae98.codelab.feature.main

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.taetae98.codelab.navigation.compose.memo.navigateToMemo
import com.taetae98.codelab.navigation.compose.poke.navigateToPoke
import com.taetae98.codelab.navigation.compose.webview.navigateToWebView
import com.taetae98.codelab.navigation.core.main.MainEntry

public fun NavGraphBuilder.mainEntry(navController: NavController) {
    composable(MainEntry.ROUTE) {
        MainRoute(
            onWebView = navController::navigateToWebView,
            onMemo = navController::navigateToMemo,
            onPoke = navController::navigateToPoke,
        )
    }
}
