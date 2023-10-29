package com.taetae98.codelab.feature.memo

import com.taetae98.codelab.library.viewmodel.KSavedStateHandle
import com.taetae98.codelab.library.viewmodel.KViewModel

internal class MemoListViewModel(
    private val kSavedStateHandle: KSavedStateHandle,
) : KViewModel() {
    val randomInt: Int = 1
}
