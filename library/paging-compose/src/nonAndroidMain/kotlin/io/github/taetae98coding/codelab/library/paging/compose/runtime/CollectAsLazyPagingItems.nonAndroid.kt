package io.github.taetae98coding.codelab.library.paging.compose.runtime

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.paging.PagingData
import io.github.taetae98coding.codelab.library.paging.compose.LazyPagingItems
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

@Composable
public actual fun <T : Any> Flow<PagingData<T>>.collectAsLazyPagingItems(
    context: CoroutineContext
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

    return lazyPagingItems
}
