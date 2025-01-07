package io.github.taetae98coding.codelab

import androidx.compose.ui.window.singleWindowApplication
import io.github.taetae98coding.codelab.app.App
import io.github.taetae98coding.codelab.app.AppModule
import io.github.taetae98coding.codelab.app.JvmAppModule
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

public fun main() {
    startKoin {
        modules(
            AppModule().module,
            JvmAppModule().module,
        )
    }

    singleWindowApplication(
        title = "CodeLab",
    ) {
        App()
    }
}
