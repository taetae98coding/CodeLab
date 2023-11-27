package com.taetae98.codelab.library.inject.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.taetae98.codelab.library.lifecycle.KSavedStateHandle
import com.taetae98.codelab.library.lifecycle.KViewModel
import kotlin.reflect.KClass
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonPrimitive
import org.koin.compose.getKoinScope
import org.koin.core.parameter.ParametersHolder

@Composable
public inline fun <reified T : KViewModel> ComponentContext.koinInject(defaultMap: Map<String, JsonPrimitive> = emptyMap()): T {
    val key = remember { requireNotNull(getKClassForKViewModel<T>().simpleName) }
    val scope = getKoinScope()

    val map = remember(this) {
        stateKeeper.consume(
            key = key,
            strategy = MapSerializer(String.serializer(), JsonPrimitive.serializer())
        )?.toMutableMap() ?: defaultMap.toMutableMap()
    }

    LaunchedEffect(this) {
        if (!stateKeeper.isRegistered(key)) {
            stateKeeper.register(
                key = key,
                strategy = MapSerializer(String.serializer(), JsonPrimitive.serializer()),
                supplier = { map }
            )
        }
    }

    return remember(this, scope) {
        instanceKeeper.getOrCreate {
            scope.get(
                parameters = {
                    ParametersHolder(mutableListOf(KSavedStateHandle(map)))
                }
            )
        }
    }
}

public inline fun <reified T : KViewModel> getKClassForKViewModel(): KClass<T> {
    return T::class
}
