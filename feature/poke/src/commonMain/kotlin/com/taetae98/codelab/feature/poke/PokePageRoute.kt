package com.taetae98.codelab.feature.poke

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import app.cash.paging.compose.collectAsLazyPagingItems

@Composable
internal fun PokePageRoute(modifier: Modifier = Modifier, onNavigateUp: () -> Unit, viewModel: PokePageViewModel) {
    val initialIndex = viewModel.initialIndex.collectAsState()

    PokePageScreen(
        modifier = modifier,
        initialIndex = initialIndex.value,
        onNavigateUp = onNavigateUp,
        pokeItems = viewModel.pokeUiState.collectAsLazyPagingItems()
    )
}
