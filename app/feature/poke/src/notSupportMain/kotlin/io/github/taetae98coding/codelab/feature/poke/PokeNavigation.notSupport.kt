package io.github.taetae98coding.codelab.feature.poke

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.github.taetae98coding.codelab.core.navigation.poke.PokeHome

public actual fun NavGraphBuilder.pokeNavigation(
    navController: NavController,
) {
    composable<PokeHome> {
        Text(text = "Not Support")
    }
}
