package io.github.taetae98coding.codelab

import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document

public fun main() {
    ComposeViewport(
        viewportContainer = requireNotNull(document.body),
    ) {
        App()
    }
}
