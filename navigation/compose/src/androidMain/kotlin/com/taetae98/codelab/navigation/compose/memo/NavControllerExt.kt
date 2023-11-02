package com.taetae98.codelab.navigation.compose.memo

import androidx.navigation.NavController
import com.taetae98.codelab.navigation.core.memo.MemoAddEntry
import com.taetae98.codelab.navigation.core.memo.MemoEntry

public fun NavController.navigateToMemo() {
    navigate(MemoEntry.ROUTE)
}

public fun NavController.navigateToMemoAdd() {
    navigate(MemoAddEntry.ROUTE)
}
