package com.taetae98.codelab.feature.memo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.taetae98.codelab.compose.icon.AddIcon
import com.taetae98.codelab.compose.icon.NavigateUpIcon
import com.taetae98.codelab.compose.textfield.TextFieldUiState
import com.taetae98.codelab.compose.textfield.TitleTextField

@Composable
internal fun MemoAddScreen(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
    uiState: MemoAddUiState,
    titleUiState: State<TextFieldUiState>,
    messageUiState: State<MemoMessageUiState>,
) {
    val hostState = remember { SnackbarHostState() }

    Scaffold(
        modifier = modifier,
        topBar = { TopBar(onNavigateUp = onNavigateUp) },
        floatingActionButton = { FloatingButton(uiState = uiState) },
        snackbarHost = { SnackbarHost(hostState) },
    ) {
        Content(
            modifier = Modifier.padding(it),
            titleUiState = titleUiState,
        )
    }

    LaunchedEffect(messageUiState.value.message) {
        when (messageUiState.value.message) {
            MemoMessage.Upsert -> hostState.showSnackbar("Add memo.")
            else -> Unit
        }

        messageUiState.value.onMessageShow()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit,
) {
    TopAppBar(
        modifier = modifier,
        title = {},
        navigationIcon = {
            IconButton(onClick = onNavigateUp) {
                NavigateUpIcon()
            }
        },
    )
}

@Composable
private fun FloatingButton(
    modifier: Modifier = Modifier,
    uiState: MemoAddUiState,
) {
    FloatingActionButton(
        modifier = modifier,
        onClick = uiState.onUpsert,
    ) {
        AddIcon()
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier,
    titleUiState: State<TextFieldUiState>,
) {
    Column(
        modifier = modifier.padding(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Title(uiState = titleUiState)
    }
}

@Composable
private fun Title(
    modifier: Modifier = Modifier,
    uiState: State<TextFieldUiState>,
) {
    Card {
        TitleTextField(
            modifier = modifier.fillMaxWidth(),
            uiState = uiState.value,
        )
    }
}
