package com.taetae98.codelab.feature.poke

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.cash.paging.compose.collectAsLazyPagingItems

@Composable
internal fun PokeListRoute(modifier: Modifier = Modifier, onNavigateUp: () -> Unit, viewModel: PokeListViewModel, onPokeItem: (Int) -> Unit) {
    PokeListScreen(
        modifier = modifier,
        onNavigateUp = onNavigateUp,
        pokeItems = viewModel.pokeUiState.collectAsLazyPagingItems(),
        onPokeItem = onPokeItem
    )
}
