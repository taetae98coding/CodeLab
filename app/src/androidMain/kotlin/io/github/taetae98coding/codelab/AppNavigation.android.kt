package io.github.taetae98coding.codelab

import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import io.github.taetae98coding.codelab.core.navigation.HomeNavKey
import io.github.taetae98coding.codelab.feature.auth.authEntryProvider
import io.github.taetae98coding.codelab.feature.home.homeEntryProvider

@Composable
internal actual fun AppNavigation(modifier: Modifier) {
    val backStack = rememberNavBackStack(HomeNavKey)

    NavDisplay(
        backStack = backStack,
        sceneStrategy = rememberListDetailSceneStrategy(),
        entryProvider = entryProvider {
            homeEntryProvider(backStack = backStack)
            authEntryProvider(backStack = backStack)
        },
    )
}
