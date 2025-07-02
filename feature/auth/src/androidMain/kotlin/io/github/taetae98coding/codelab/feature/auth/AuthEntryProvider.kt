package io.github.taetae98coding.codelab.feature.auth

import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.navigation3.runtime.EntryProviderBuilder
import androidx.navigation3.runtime.NavBackStack
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import io.github.taetae98coding.codelab.core.navigation.AuthNavKey

public fun EntryProviderBuilder<NavKey>.authEntryProvider(
    backStack: NavBackStack,
) {
    entry<AuthNavKey>(
        metadata = ListDetailSceneStrategy.detailPane(),
    ) {
        AuthScreen(
            onNavigateUp = backStack::removeLastOrNull,
        )
    }
}
