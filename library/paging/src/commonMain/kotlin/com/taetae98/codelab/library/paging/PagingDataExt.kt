package com.taetae98.codelab.library.paging

import app.cash.paging.PagingData
import app.cash.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest

public inline fun <T : Any, R : Any> Flow<PagingData<T>>.mapPaging(noinline transform: suspend (T) -> R): Flow<PagingData<R>> {
    return map { it.map(transform) }
}

public inline fun <T : Any, R : Any> Flow<PagingData<T>>.mapPagingLatest(noinline transform: suspend (T) -> R): Flow<PagingData<R>> {
    return mapLatest { it.map(transform) }
}
