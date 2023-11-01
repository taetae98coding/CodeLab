package com.taetae98.codelab.app

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.taetae98.codelab.feature.main.mainEntry
import com.taetae98.codelab.feature.memo.memoEntry
import com.taetae98.codelab.feature.webview.webViewEntry
import com.taetae98.codelab.navigation.core.AppEntry
import com.taetae98.codelab.navigation.core.main.MainEntry

@Composable
public fun AppEntry(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()

    CodeLabTheme {
        NavHost(
            modifier = modifier,
            navController = navController,
            startDestination = MainEntry.ROUTE,
            route = AppEntry.ROUTE,
        ) {
            mainEntry(navController = navController)
            webViewEntry(navController = navController)
            memoEntry(navController = navController)
        }
    }
}
