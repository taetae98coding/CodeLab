package com.taetae98.codelab.library.image

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsChannel
import io.ktor.util.toByteArray
import org.jetbrains.skia.Image

@Composable
public actual fun UriImage(modifier: Modifier, uri: String) {
    val state = getAsyncImage(uri)
    val bitmap = state.value

    if (bitmap == null) {
        Box(modifier)
    } else {
        Image(
            modifier = modifier,
            bitmap = bitmap,
            contentDescription = null,
        )
    }
}

@Composable
private fun getAsyncImage(uri: String): State<ImageBitmap?> {
    val state = remember { mutableStateOf<ImageBitmap?>(null) }

    LaunchedEffect(uri) {
        runCatching {
            val response = HttpClient().get(uri)
            val bytes = response.bodyAsChannel().toByteArray()
            val bitmap = Image.makeFromEncoded(bytes)

            state.value = bitmap.toComposeImageBitmap()
        }
    }

    return state
}
