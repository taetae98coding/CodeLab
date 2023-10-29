package com.taetae98.codelab.feature.memo

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.taetae98.codelab.navigation.core.memo.MemoEntry

@Composable
public fun MemoEntry(
    modifier: Modifier = Modifier,
    entry: MemoEntry,
) {
    Text(text = "Memo")
}