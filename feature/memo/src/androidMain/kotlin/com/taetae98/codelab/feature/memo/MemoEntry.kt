package com.taetae98.codelab.feature.memo

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.taetae98.codelab.navigation.core.memo.MemoEntry
import com.taetae98.codelab.navigation.core.memo.MemoListEntry

public fun NavGraphBuilder.memoEntry(
    navController: NavController,
) {
    navigation(
        startDestination = MemoListEntry.ROUTE,
        route = MemoEntry.ROUTE,
    ) {
        composable(MemoListEntry.ROUTE) {
        }
    }
}
