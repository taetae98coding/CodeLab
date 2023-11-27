package com.taetae98.codelab.feature.datastore

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.taetae98.codelab.compose.icon.NavigateUpIcon

@Composable
internal fun DatastoreScreen(modifier: Modifier, onNavigateUp: () -> Unit, uiState: State<DatastoreUiState>) {
    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(onNavigateUp = onNavigateUp)
        }
    ) {
        Content(
            modifier = Modifier.padding(it),
            uiState = uiState
        )
    }
}

@Composable
private fun Content(modifier: Modifier = Modifier, uiState: State<DatastoreUiState>) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth()
                .padding(12.dp),
            value = uiState.value.value,
            onValueChange = uiState.value.setValue,
            label = {
                Text(text = "Preference Value")
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopBar(modifier: Modifier = Modifier, onNavigateUp: () -> Unit) {
    TopAppBar(
        modifier = modifier,
        title = {},
        navigationIcon = {
            IconButton(onClick = onNavigateUp) {
                NavigateUpIcon()
            }
        }
    )
}
