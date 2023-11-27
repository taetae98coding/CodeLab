package com.taetae98.codelab.feature.datastore

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.taetae98.codelab.navigation.core.datastore.DataStoreEntry

public fun NavGraphBuilder.datastoreEntry(navController: NavController) {
    composable(
        route = DataStoreEntry.ROUTE
    ) {
        val viewModel = hiltViewModel<DataStoreViewModelImpl>()

        DatastoreRoute(
            viewModel = viewModel,
            onNavigateUp = navController::navigateUp
        )
    }
}
