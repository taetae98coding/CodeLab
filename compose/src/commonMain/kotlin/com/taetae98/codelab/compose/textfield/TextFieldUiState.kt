package com.taetae98.codelab.compose.textfield

public data class TextFieldUiState(
    val value: String,
    val onValueChange: (String) -> Unit
)
