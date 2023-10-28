package com.taetae98.codelab

import androidx.compose.ui.window.ComposeUIViewController
import com.taetae98.codelab.app.AppEntry
import com.taetae98.codelab.navigation.core.app.AppEntry
import platform.UIKit.UIViewController

public fun compose(entry: AppEntry): UIViewController {
    return ComposeUIViewController {
        AppEntry(entry = entry)
    }
}
