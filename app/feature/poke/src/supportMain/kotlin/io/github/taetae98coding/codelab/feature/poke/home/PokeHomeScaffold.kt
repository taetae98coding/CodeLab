package io.github.taetae98coding.codelab.feature.poke.home

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import io.github.taetae98coding.codelab.domain.poke.entity.Poke
import io.github.taetae98coding.codelab.library.paging.compose.LazyPagingItems
import io.github.taetae98coding.codelab.library.paging.compose.ext.itemKey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PokeHomeScaffold(
    modifier: Modifier = Modifier,
    onPoke: (Int) -> Unit,
    pagingItems: LazyPagingItems<Poke>,
) {
    Scaffold(
        modifier = modifier,
        topBar = { TopAppBar(title = { Text(text = "Poke") }) },
    ) {
        Content(
            modifier = Modifier.fillMaxSize()
                .padding(it),
            onPoke = onPoke,
            pagingItems = pagingItems,
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    onPoke: (Int) -> Unit,
    pagingItems: LazyPagingItems<Poke>,
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier,
        contentPadding = PaddingValues(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        items(
            count = pagingItems.itemCount,
            key = pagingItems.itemKey { it.id },
        ) { index ->
            PokeItem(
                uiState = pagingItems[index],
                onClick = { pagingItems[index]?.id?.let(onPoke) },
                modifier = Modifier.fillMaxSize(),
            )
        }
    }
}

@Composable
private fun PokeItem(
    uiState: Poke?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onClick,
        modifier = modifier,
    ) {
        AsyncImage(
            model = uiState?.thumbnail,
            contentDescription = uiState?.name,
            modifier = Modifier.fillMaxWidth()
                .aspectRatio(1F),
        )
        Text(
            text = uiState?.name.orEmpty(),
            modifier = Modifier.fillMaxWidth()
                .basicMarquee(iterations = Int.MAX_VALUE),
            textAlign = TextAlign.Center,
            maxLines = 1,
        )
    }
}
