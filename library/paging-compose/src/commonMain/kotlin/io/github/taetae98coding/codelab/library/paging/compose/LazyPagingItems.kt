package io.github.taetae98coding.codelab.library.paging.compose

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
public expect class LazyPagingItems<T: Any> {
    public val itemCount: Int

    public operator fun get(index: Int): T?
}
