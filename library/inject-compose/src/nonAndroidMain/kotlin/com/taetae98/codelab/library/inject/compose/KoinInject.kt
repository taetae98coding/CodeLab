package com.taetae98.codelab.library.inject.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.taetae98.codelab.library.lifecycle.SavedStateHandle
import com.taetae98.codelab.library.lifecycle.ViewModel
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonPrimitive
import org.koin.compose.getKoinScope
import org.koin.core.parameter.ParametersHolder

@Composable
public inline fun <reified T : ViewModel> ComponentContext.koinInject(): T {
    val scope = getKoinScope()
    val map = remember(this) {
        stateKeeper.consume(
            key = requireNotNull(T::class.qualifiedName),
            strategy = MapSerializer(String.serializer(), JsonPrimitive.serializer()),
        )?.toMutableMap() ?: mutableMapOf()
    }

    LaunchedEffect(this) {
        stateKeeper.register(
            key = requireNotNull(T::class.qualifiedName),
            strategy = MapSerializer(String.serializer(), JsonPrimitive.serializer()),
            supplier = { map }
        )
    }

    return remember(this, scope) {
        instanceKeeper.getOrCreate {
            scope.get(
                parameters = {
                    ParametersHolder(mutableListOf(SavedStateHandle(map)))
                }
            )
        }
    }
}