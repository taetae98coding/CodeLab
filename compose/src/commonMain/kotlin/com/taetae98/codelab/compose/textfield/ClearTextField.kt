package com.taetae98.codelab.compose.textfield

import androidx.compose.material3.IconButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taetae98.codelab.compose.icon.ClearIcon

@Composable
public fun ClearTextField(
    modifier: Modifier = Modifier,
    uiState: TextFieldUiState,
    label: @Composable (() -> Unit)? = null,
    singleLine: Boolean = false,
    maxLines: Int = if (singleLine) 1 else Int.MAX_VALUE,
    colors: TextFieldColors = TextFieldDefaults.colors(),
) {
    TextField(
        modifier = modifier,
        value = uiState.value,
        onValueChange = uiState.onValueChange,
        label = label,
        trailingIcon = {
            if (uiState.value.isNotEmpty()) {
                IconButton(onClick = { uiState.onValueChange("") }) {
                    ClearIcon()
                }
            }
        },
        singleLine = singleLine,
        maxLines = maxLines,
        colors = colors,
    )
}
