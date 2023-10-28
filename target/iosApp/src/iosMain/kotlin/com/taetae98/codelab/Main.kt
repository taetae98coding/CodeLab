package com.taetae98.codelab

import androidx.compose.ui.window.ComposeUIViewController
import com.taetae98.codelab.app.AppRoute
import platform.UIKit.UIViewController

public fun compose(): UIViewController {
    return ComposeUIViewController {
        AppRoute()
    }
}
