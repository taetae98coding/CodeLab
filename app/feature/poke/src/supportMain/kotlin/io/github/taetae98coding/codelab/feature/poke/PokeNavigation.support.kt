package io.github.taetae98coding.codelab.feature.poke

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.dialog
import io.github.taetae98coding.codelab.core.navigation.poke.PokeDetail
import io.github.taetae98coding.codelab.core.navigation.poke.PokeHome
import io.github.taetae98coding.codelab.feature.poke.detail.PokeDetailRoute
import io.github.taetae98coding.codelab.feature.poke.home.PokeHomeRoute

@OptIn(ExperimentalSharedTransitionApi::class)
public actual fun NavGraphBuilder.pokeNavigation(
    navController: NavController,
    sharedTransitionScope: SharedTransitionScope,
) {
    composable<PokeHome> {
        PokeHomeRoute(
            navigateToDetail = { navController.navigate(PokeDetail(it)) },
        )
    }

    dialog<PokeDetail> {
        PokeDetailRoute(
            navigateUp = navController::popBackStack,
        )
    }
}
