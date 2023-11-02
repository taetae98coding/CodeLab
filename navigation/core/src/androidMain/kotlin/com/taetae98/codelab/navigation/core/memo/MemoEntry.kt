package com.taetae98.codelab.navigation.core.memo

import com.taetae98.codelab.navigation.core.AppEntry

public data object MemoEntry {
    internal const val PREFIX: String = "${AppEntry.PREFIX}/memo"
    public const val ROUTE: String = PREFIX
}
