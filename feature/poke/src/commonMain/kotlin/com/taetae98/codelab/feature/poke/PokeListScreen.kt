package com.taetae98.codelab.feature.poke

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import app.cash.paging.compose.LazyPagingItems

@Composable
internal fun PokeListScreen(
    modifier: Modifier = Modifier,
    pokeItems: LazyPagingItems<String>
) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(
            count = pokeItems.itemCount
        ) {
            Text(text = pokeItems[it].orEmpty())
        }
    }
}