package com.taetae98.codelab.library.image

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
public actual fun UriImage(modifier: Modifier, uri: String) {
    AsyncImage(
        modifier = modifier,
        model = uri,
        contentDescription = null,
    )
}
