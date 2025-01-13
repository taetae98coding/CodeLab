package io.github.taetae98coding.codelab.core.poke.service.ext

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

public actual fun providesHttpClientEngine(): HttpClientEngine {
    return Darwin.create()
}
