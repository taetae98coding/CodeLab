package com.taetae98.codelab.compose.icon

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Navigation
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
public fun NavigationIcon(modifier: Modifier = Modifier) {
    Icon(
        modifier = modifier,
        imageVector = Icons.Rounded.Navigation,
        contentDescription = null,
    )
}
