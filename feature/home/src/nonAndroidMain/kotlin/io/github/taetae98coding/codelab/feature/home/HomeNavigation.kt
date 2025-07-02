package io.github.taetae98coding.codelab.feature.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.github.taetae98coding.codelab.core.navigation.AuthDestination
import io.github.taetae98coding.codelab.core.navigation.HomeDestination

public fun NavGraphBuilder.homeNavigation(
    navController: NavController,
) {
    composable<HomeDestination> {
        HomeScreen(onNavigateToAuth = { navController.navigate(AuthDestination) })
    }
}
