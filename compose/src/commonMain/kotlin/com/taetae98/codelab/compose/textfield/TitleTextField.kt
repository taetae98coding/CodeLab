package com.taetae98.codelab.compose.textfield

import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
public fun TitleTextField(
    modifier: Modifier = Modifier,
    uiState: TextFieldUiState,
) {
    ClearTextField(
        modifier = modifier,
        uiState = uiState,
        label = {
            Text(text = "Title")
        },
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
        ),
    )
}
