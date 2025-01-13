package io.github.taetae98coding.codelab.feature.poke

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.github.taetae98coding.codelab.core.navigation.poke.PokeHome

@OptIn(ExperimentalSharedTransitionApi::class)
public actual fun NavGraphBuilder.pokeNavigation(
    navController: NavController,
    sharedTransitionScope: SharedTransitionScope,
) {
    composable<PokeHome> {
        Text(text = "Not Support")
    }
}
