package com.taetae98.codelab.feature.poke

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.itemContentType
import app.cash.paging.compose.itemKey
import com.taetae98.codelab.compose.icon.NavigateUpIcon
import com.taetae98.codelab.library.image.UriImage

@Composable
internal fun PokeListScreen(modifier: Modifier = Modifier, onNavigateUp: () -> Unit, pokeItems: LazyPagingItems<PokeUiState>) {
    Scaffold(
        modifier = modifier,
        topBar = { TopBar(onNavigateUp = onNavigateUp) },
    ) {
        Content(
            modifier = Modifier.padding(it),
            pokeItems = pokeItems,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(modifier: Modifier = Modifier, onNavigateUp: () -> Unit) {
    TopAppBar(
        modifier = modifier,
        title = {},
        navigationIcon = {
            IconButton(onClick = onNavigateUp) {
                NavigateUpIcon()
            }
        },
    )
}

@Composable
private fun Content(modifier: Modifier = Modifier, pokeItems: LazyPagingItems<PokeUiState>) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        items(
            count = pokeItems.itemCount,
            key = pokeItems.itemKey { it.id },
            contentType = pokeItems.itemContentType { "Poke" },
        ) {
            PokeItem(uiState = pokeItems[it])
        }
    }
}

@Composable
private fun PokeItem(modifier: Modifier = Modifier, uiState: PokeUiState?) {
    Card(
        modifier = modifier.fillMaxWidth(),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            UriImage(
                modifier = Modifier.size(64.dp),
                uri = uiState?.image.orEmpty(),
            )
            Column {
                Text(text = uiState?.id?.toString().orEmpty())
                Text(text = uiState?.name.orEmpty())
            }
        }
    }
}
