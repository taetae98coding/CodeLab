package com.taetae98.codelab.feature.memo

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun MemoListRoute(
    modifier: Modifier = Modifier,
    memoListViewModel: MemoListViewModel,
) {
    Column {
        Text(text = memoListViewModel.randomInt.toString())
        MemoListScreen(
            modifier = modifier,
        )
    }
}