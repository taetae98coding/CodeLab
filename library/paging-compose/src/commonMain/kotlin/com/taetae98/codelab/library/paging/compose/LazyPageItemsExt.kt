package com.taetae98.codelab.library.paging.compose

import app.cash.paging.compose.LazyPagingItems

public fun <T : Any> LazyPagingItems<T>.safeGet(index: Int): T? {
    return if (itemCount > index) {
        get(index)
    } else {
        null
    }
}
