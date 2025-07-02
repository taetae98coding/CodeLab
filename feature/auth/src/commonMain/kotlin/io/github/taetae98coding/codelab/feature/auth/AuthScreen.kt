package io.github.taetae98coding.codelab.feature.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import io.github.taetae98coding.codelab.compose.icon.NavigateUpIcon
import io.github.taetae98coding.codelab.compose.preview.CodeLabPreview
import io.github.taetae98coding.codelab.compose.theme.CodeLabTheme
import io.github.taetae98coding.google.credentials.GoogleCredentialsOptions
import io.github.taetae98coding.google.credentials.compose.rememberGoogleCredentialsManager
import kotlinx.coroutines.launch

@Composable
internal fun AuthScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val coroutineScope = rememberCoroutineScope()
    val googleCredentialsManager = rememberGoogleCredentialsManager()

    var text by rememberSaveable { mutableStateOf("Sign In") }

    Scaffold(
        modifier = modifier,
        topBar = { TopBar(onNavigateUp = onNavigateUp) },
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            Column(
                modifier = Modifier.weight(1F)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = text,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
            }
            LazyRow {
                item {
                    TextButton(
                        onClick = {
                            coroutineScope.launch {
                                text = "Google Sign In ..."
                                text = try {
                                    "Google Id Token: ${googleCredentialsManager.getIdToken(GoogleCredentialsOptions.default())}"
                                } catch (throwable: Throwable) {
                                    throwable.printStackTrace()
                                    "Error : $throwable"
                                }
                            }
                        },
                    ) {
                        Text(text = "Google Sign In")
                    }
                }
            }
        }
    }
}

@Composable
private fun TopBar(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = { Text(text = "Auth") },
        navigationIcon = {
            IconButton(onClick = onNavigateUp) {
                NavigateUpIcon(contentDescription = "Navigate Up")
            }
        },
    )
}

@CodeLabPreview
@Composable
private fun Preview() {
    CodeLabTheme {
        AuthScreen(
            onNavigateUp = {},
        )
    }
}
