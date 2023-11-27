package com.taetae98.codelab.feature.webview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.taetae98.codelab.compose.icon.NavigateUpIcon
import com.taetae98.codelab.compose.icon.NavigationIcon
import com.taetae98.codelab.library.webview.WebView
import com.taetae98.codelab.library.webview.WebViewUiState

@Composable
internal fun WebViewScreen(modifier: Modifier = Modifier, onNavigateUp: () -> Unit) {
    val uiState =
        remember { mutableStateOf<WebViewUiState>(WebViewUiState.Url("https://www.naver.com")) }
    val webViewDialogVisibleState = remember { mutableStateOf(false) }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(
                onNavigateUp = onNavigateUp,
                onNavigation = { webViewDialogVisibleState.value = true }
            )
        }
    ) {
        WebView(
            modifier = Modifier.fillMaxSize()
                .padding(it),
            uiState = uiState.value
        )
    }

    WebViewDialog(
        uiState = uiState,
        visibleState = webViewDialogVisibleState
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(modifier: Modifier = Modifier, onNavigateUp: () -> Unit, onNavigation: () -> Unit) {
    TopAppBar(
        modifier = modifier,
        title = {},
        navigationIcon = {
            IconButton(onClick = onNavigateUp) {
                NavigateUpIcon()
            }
        },
        actions = {
            IconButton(onClick = onNavigation) {
                NavigationIcon()
            }
        }
    )
}

@Composable
private fun WebViewDialog(uiState: MutableState<WebViewUiState>, visibleState: MutableState<Boolean>) {
    if (visibleState.value) {
        Dialog(
            onDismissRequest = { visibleState.value = false }
        ) {
            DialogContent(
                modifier = Modifier.fillMaxWidth(),
                uiState = uiState,
                visibleState = visibleState
            )
        }
    }
}

@Composable
private fun DialogContent(modifier: Modifier = Modifier, uiState: MutableState<WebViewUiState>, visibleState: MutableState<Boolean>) {
    Card {
        Column(
            modifier = modifier
        ) {
            val type = remember {
                val type = when (uiState.value) {
                    is WebViewUiState.Url -> WebViewType.URL
                    is WebViewUiState.Html -> WebViewType.HTML
                }

                mutableStateOf(type)
            }
            val data = remember { mutableStateOf("") }

            DialogTypeRadioGroup(type = type)
            DialogDataTextField(
                type = type,
                data = data
            )
            DialogButtonLayout(
                type = type,
                data = data,
                uiState = uiState,
                visibleState = visibleState
            )
        }
    }
}

@Composable
private fun DialogTypeRadioGroup(modifier: Modifier = Modifier, type: MutableState<WebViewType>) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        WebViewType.entries.forEach {
            Row(
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable(onClick = { type.value = it })
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = it == type.value,
                    onClick = null
                )
                Text(
                    text = it.name
                )
            }
        }
    }
}

@Composable
private fun DialogDataTextField(modifier: Modifier = Modifier, type: State<WebViewType>, data: MutableState<String>) {
    val isSingleLine = type.value == WebViewType.URL
    val lines = if (type.value == WebViewType.URL) {
        1
    } else {
        10
    }

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = data.value,
        onValueChange = { data.value = it },
        singleLine = isSingleLine,
        maxLines = lines,
        minLines = lines,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent
        )
    )
}

@Composable
private fun DialogButtonLayout(modifier: Modifier = Modifier, visibleState: MutableState<Boolean>, type: State<WebViewType>, data: State<String>, uiState: MutableState<WebViewUiState>) {
    TextButton(
        modifier = modifier.fillMaxWidth(),
        onClick = {
            when (type.value) {
                WebViewType.URL -> uiState.value = WebViewUiState.Url(data.value)
                WebViewType.HTML -> uiState.value = WebViewUiState.Html(data.value)
            }

            visibleState.value = false
        },
        enabled = data.value.isNotEmpty()
    ) {
        Text(text = "Navigate")
    }
}
