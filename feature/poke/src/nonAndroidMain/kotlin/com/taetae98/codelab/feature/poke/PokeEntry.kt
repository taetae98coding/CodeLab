package com.taetae98.codelab.feature.poke

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.Children
import com.arkivanov.decompose.extensions.compose.jetbrains.stack.animation.stackAnimation
import com.taetae98.codelab.library.inject.compose.koinInject
import com.taetae98.codelab.navigation.compose.koinNavInject
import com.taetae98.codelab.navigation.core.poke.PokeEntry
import com.taetae98.codelab.navigation.core.poke.PokeListEntry
import com.taetae98.codelab.navigation.core.poke.PokePageEntry

@Composable
public fun PokeEntry(modifier: Modifier = Modifier, entry: PokeEntry) {
    Children(
        modifier = modifier,
        stack = entry.stack,
        animation = stackAnimation(),
    ) {
        when (val instance = it.instance) {
            is PokeListEntry -> {
                PokeListRoute(
                    onNavigateUp = instance.onNavigateUp,
                    viewModel = instance.koinInject(),
                    onPokeItem = instance.onNavigateToPokePage,
                )
            }

            is PokePageEntry -> {
                PokePageRoute(
                    onNavigateUp = instance.onNavigateUp,
                    viewModel = instance.koinNavInject(),
                )
            }
        }
    }
}
