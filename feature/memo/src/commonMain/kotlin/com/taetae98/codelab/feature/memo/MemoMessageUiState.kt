package com.taetae98.codelab.feature.memo

internal data class MemoMessageUiState(
    val message: MemoMessage? = null,
    val onMessageShow: () -> Unit,
)
