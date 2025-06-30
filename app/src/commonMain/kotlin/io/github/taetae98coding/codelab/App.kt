package io.github.taetae98coding.codelab

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.github.taetae98coding.codelab.compose.CodeLabTheme

@Composable
public fun App() {
    CodeLabTheme {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center,
        ) {
            Text(text = "Hello World!")
        }
    }
}
