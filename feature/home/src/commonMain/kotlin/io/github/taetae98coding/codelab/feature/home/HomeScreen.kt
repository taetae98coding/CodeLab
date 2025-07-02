package io.github.taetae98coding.codelab.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.taetae98coding.codelab.compose.preview.CodeLabPreview
import io.github.taetae98coding.codelab.compose.theme.CodeLabTheme
import io.github.taetae98coding.codelab.feature.home.chip.Platform
import io.github.taetae98coding.codelab.feature.home.chip.PlatformChip

@Composable
internal fun HomeScreen(
    onNavigateToAuth: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        modifier = modifier,
        topBar = { TopBar() },
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues)
                .padding(12.dp),
        ) {
            item {
                AuthCard(
                    onClick = onNavigateToAuth,
                    modifier = Modifier.fillParentMaxWidth(),
                )
            }
        }
    }
}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = { Text(text = "CodeLab") },
        modifier = modifier,
    )
}

@Composable
private fun AuthCard(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onClick,
        modifier = modifier,
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Column(modifier = Modifier.padding(horizontal = 8.dp)) {
            Text(
                text = "Auth",
                style = CodeLabTheme.typography.titleLargeEmphasized,
            )
            Text(text = "Apple, Google SignIn")
        }
        LazyRow(
            contentPadding = PaddingValues(8.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(
                items = listOf(Platform.Android, Platform.IOS, Platform.Desktop),
            ) {
                PlatformChip(platform = it)
            }
        }
    }
}

@CodeLabPreview
@Composable
private fun Preview() {
    CodeLabTheme {
        HomeScreen(
            onNavigateToAuth = {},
        )
    }
}
