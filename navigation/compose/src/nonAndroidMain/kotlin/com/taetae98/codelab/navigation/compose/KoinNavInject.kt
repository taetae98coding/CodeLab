package com.taetae98.codelab.navigation.compose

import androidx.compose.runtime.Composable
import com.taetae98.codelab.library.inject.compose.koinInject
import com.taetae98.codelab.library.lifecycle.KViewModel
import com.taetae98.codelab.navigation.core.Entry

@Composable
public inline fun <reified T : KViewModel> Entry.koinNavInject(): T {
    return koinInject(arguments)
}