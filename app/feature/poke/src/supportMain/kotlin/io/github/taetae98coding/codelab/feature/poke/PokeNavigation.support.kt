package io.github.taetae98coding.codelab.feature.poke

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.paging.CombinedLoadStates
import androidx.paging.ItemSnapshotList
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.PagingData
import androidx.paging.PagingDataEvent
import androidx.paging.PagingDataPresenter
import coil3.compose.AsyncImage
import io.github.taetae98coding.codelab.core.navigation.poke.PokeHome
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.withContext
import org.koin.compose.viewmodel.koinViewModel

public actual fun NavGraphBuilder.pokeNavigation(
    navController: NavController,
) {
    composable<PokeHome> {
        val viewModel = koinViewModel<PokeViewModel>()
        val lazyItems = viewModel.paging.collectAsLazyPagingItems()

        LazyVerticalGrid(
            columns = GridCells.Adaptive(150.dp),
            modifier = Modifier.fillMaxSize(),
        ) {
            items(
                count = lazyItems.itemCount,
            ) {
                Card {
                    AsyncImage(
                        model = lazyItems[it]?.thumbnail,
                        contentDescription = lazyItems[it]?.name,
                        modifier = Modifier.fillMaxWidth()
                            .aspectRatio(1F),
                    )
                    Text(
                        text = lazyItems[it]?.name.orEmpty(),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

private val IncompleteLoadState = LoadState.NotLoading(false)
private val InitialLoadStates = LoadStates(
    refresh = LoadState.Loading,
    prepend = IncompleteLoadState,
    append = IncompleteLoadState,
)

public class LazyPagingItems<T : Any> internal constructor(
    private val flow: Flow<PagingData<T>>,
) {
    private val pagingDataPresenter = object : PagingDataPresenter<T>(
        mainContext = Dispatchers.Main,
        cachedPagingData =
            if (flow is SharedFlow<PagingData<T>>) flow.replayCache.firstOrNull() else null,
    ) {
        override suspend fun presentPagingDataEvent(
            event: PagingDataEvent<T>,
        ) {
            updateItemSnapshotList()
        }
    }

    private fun updateItemSnapshotList() {
        itemSnapshotList = pagingDataPresenter.snapshot()
    }

    public var itemSnapshotList: ItemSnapshotList<T> by mutableStateOf(pagingDataPresenter.snapshot())
        private set

    public val itemCount: Int
        get() {
            return itemSnapshotList.size
        }

    public var loadState: CombinedLoadStates by mutableStateOf(
        pagingDataPresenter.loadStateFlow.value
            ?: CombinedLoadStates(
                refresh = InitialLoadStates.refresh,
                prepend = InitialLoadStates.prepend,
                append = InitialLoadStates.append,
                source = InitialLoadStates,
            ),
    )
        private set

    internal suspend fun collectLoadState() {
        pagingDataPresenter.loadStateFlow.filterNotNull().collect {
            loadState = it
        }
    }

    internal suspend fun collectPagingData() {
        flow.collectLatest {
            pagingDataPresenter.collectFrom(it)
        }
    }

    public operator fun get(index: Int): T? {
        pagingDataPresenter[index]
        return itemSnapshotList[index]
    }
}

@Composable
public fun <T : Any> Flow<PagingData<T>>.collectAsLazyPagingItems(
    context: CoroutineContext = EmptyCoroutineContext,
): LazyPagingItems<T> {

    val lazyPagingItems = remember(this) { LazyPagingItems(this) }

    LaunchedEffect(lazyPagingItems) {
        if (context == EmptyCoroutineContext) {
            lazyPagingItems.collectPagingData()
        } else {
            withContext(context) {
                lazyPagingItems.collectPagingData()
            }
        }
    }

    LaunchedEffect(lazyPagingItems) {
        if (context == EmptyCoroutineContext) {
            lazyPagingItems.collectLoadState()
        } else {
            withContext(context) {
                lazyPagingItems.collectLoadState()
            }
        }
    }

    return lazyPagingItems
}
