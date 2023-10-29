package com.taetae98.codelab.feature.memo

import com.taetae98.codelab.library.viewmodel.SavedStateHandle
import com.taetae98.codelab.library.viewmodel.ViewModel
import kotlin.random.Random

internal actual class MemoListViewModel(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    actual val randomInt: Int = savedStateHandle.getStateFlow("hi", Random.nextInt()).value
}
