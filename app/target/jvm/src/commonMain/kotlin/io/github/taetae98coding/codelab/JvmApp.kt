package io.github.taetae98coding.codelab

import androidx.compose.ui.window.singleWindowApplication
import io.github.taetae98coding.codelab.app.App
import io.github.taetae98coding.codelab.app.AppModule
import io.github.taetae98coding.codelab.app.AppPlatformModule
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module

public fun main() {
    startKoin {
        modules(
            AppModule().module,
            AppPlatformModule().module,
        )
    }

    singleWindowApplication(
        title = "CodeLab",
    ) {
        App()
    }
}
