package com.taetae98.codelab.feature.poke

import kotlinx.collections.immutable.ImmutableList

internal sealed class PokeDetailUiState {
    abstract val id: Int
    abstract val name: String

    data class Loading(
        override val id: Int,
        override val name: String,
        private val fetch: (id: Int) -> Unit
    ) : PokeDetailUiState() {
        fun onFetch() {
            fetch(id)
        }
    }

    data class Detail(
        override val id: Int,
        override val name: String,
        val imageList: ImmutableList<String>
    ) : PokeDetailUiState()
}
