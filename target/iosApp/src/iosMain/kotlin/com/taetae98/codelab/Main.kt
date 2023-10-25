package com.taetae98.codelab

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeUIViewController
import com.taetae98.codelab.app.AppRoute
import platform.UIKit.UIViewController

public fun compose(): UIViewController {
    return ComposeUIViewController {
        AppRoute(modifier = Modifier.fillMaxSize())
    }
}
