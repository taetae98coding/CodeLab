package io.github.taetae98coding.codelab

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import io.github.taetae98coding.codelab.core.navigation.HomeDestination
import io.github.taetae98coding.codelab.feature.auth.authNavigation
import io.github.taetae98coding.codelab.feature.home.homeNavigation

@Composable
internal actual fun AppNavigation(
    modifier: Modifier,
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = HomeDestination,
    ) {
        homeNavigation(navController = navController)
        authNavigation(navController = navController)
    }
}
