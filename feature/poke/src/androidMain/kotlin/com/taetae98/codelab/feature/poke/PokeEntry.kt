package com.taetae98.codelab.feature.poke

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.taetae98.codelab.navigation.compose.poke.navigateToPokePage
import com.taetae98.codelab.navigation.core.poke.PokeEntry
import com.taetae98.codelab.navigation.core.poke.PokeListEntry
import com.taetae98.codelab.navigation.core.poke.PokePageEntry

public fun NavGraphBuilder.pokeEntry(navController: NavController) {
    navigation(
        startDestination = PokeListEntry.ROUTE,
        route = PokeEntry.ROUTE,
    ) {
        composable(route = PokeListEntry.ROUTE) {
            PokeListRoute(
                onNavigateUp = navController::navigateUp,
                viewModel = hiltViewModel<PokeListViewModelImpl>(),
                onPokeItem = navController::navigateToPokePage,
            )
        }

        composable(
            route = PokePageEntry.ROUTE,
            arguments = PokePageEntry.argument,
        ) {
            PokePageRoute(
                onNavigateUp = navController::navigateUp,
                viewModel = hiltViewModel<PokePageViewModelImpl>()
            )
        }
    }
}
