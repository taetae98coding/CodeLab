package com.taetae98.codelab.feature.google.oauth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taetae98.codelab.navigation.core.google.oauth.GoogleOAuthEntry

@Composable
public fun GoogleOAuthEntry(
    modifier: Modifier = Modifier,
    entry: GoogleOAuthEntry,
) {
    GoogleOAuthRoute(
        modifier = modifier,
        onNavigateUp = entry.onNavigateUp,
    )
}