package com.taetae98.codelab.feature.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.collections.immutable.persistentListOf

@Composable
@Preview
private fun MainItemPreview() {
    MainItem(
        title = "Title",
        platformList = persistentListOf(Platform.ANDROID, Platform.IOS, Platform.JVM),
        description = "Description",
        onClick = {}
    )
}
