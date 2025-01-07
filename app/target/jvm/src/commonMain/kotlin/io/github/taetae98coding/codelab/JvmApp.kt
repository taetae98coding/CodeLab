package io.github.taetae98coding.codelab

import androidx.compose.ui.window.singleWindowApplication
import io.github.taetae98coding.codelab.app.App

public fun main() {
    singleWindowApplication(
        title = "CodeLab",
    ) {
        App()
    }
}
