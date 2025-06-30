package io.github.taetae98coding.codelab

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

public fun compose(): UIViewController {
    return ComposeUIViewController {
        App()
    }
}
