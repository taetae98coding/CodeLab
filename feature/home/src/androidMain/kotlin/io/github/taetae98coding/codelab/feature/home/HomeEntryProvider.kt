package io.github.taetae98coding.codelab.feature.home

import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import io.github.taetae98coding.codelab.core.navigation.AuthNavKey
import io.github.taetae98coding.codelab.core.navigation.HomeNavKey

public fun EntryProviderBuilder<NavKey>.homeEntryProvider(
    backStack: NavBackStack,
) {
    entry<HomeNavKey>(
        metadata = ListDetailSceneStrategy.listPane(),
    ) {
        HomeScreen(
            onNavigateToAuth = { backStack.add(AuthNavKey) },
        )
    }
}
