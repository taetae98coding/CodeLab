package io.github.taetae98coding.codelab.feature.auth

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.github.taetae98coding.codelab.core.navigation.AuthDestination

public fun NavGraphBuilder.authNavigation(
    navController: NavController,
) {
    composable<AuthDestination> {
        AuthScreen(onNavigateUp = navController::popBackStack)
    }
}
