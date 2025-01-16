package io.github.taetae98coding.codelab.library.paging.compose

import androidx.paging.CombinedLoadStates

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
public expect class LazyPagingItems<T: Any> {
    public val itemCount: Int
    public var loadState: CombinedLoadStates
        private set

    public operator fun get(index: Int): T?

    public fun peek(index: Int): T?
}
