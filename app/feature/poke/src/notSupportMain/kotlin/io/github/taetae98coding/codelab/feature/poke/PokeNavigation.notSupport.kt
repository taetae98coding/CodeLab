package io.github.taetae98coding.codelab.feature.poke

import androidx.compose.material3.Text
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

public actual fun NavGraphBuilder.pokeNavigation(
    navController: NavController,
) {
    composable("poke") {
        Text(text = "Not Support")
    }
}
