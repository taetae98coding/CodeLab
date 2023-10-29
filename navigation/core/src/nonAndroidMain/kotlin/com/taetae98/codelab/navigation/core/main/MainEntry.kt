package com.taetae98.codelab.navigation.core.main

import com.taetae98.codelab.navigation.core.Entry

public class MainEntry(
    public val onWebView: () -> Unit,
    public val onMemo: () -> Unit,
) : Entry()
