package com.taetae98.codelab.feature.google.oauth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun GoogleOAuthRoute(
    modifier: Modifier = Modifier,
    onNavigateUp: () -> Unit
) {
    GoogleOAuthScreen(
        modifier = modifier,
        onNavigateUp = onNavigateUp,
    )
}