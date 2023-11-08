package com.taetae98.codelab.library.inject.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import com.taetae98.codelab.library.lifecycle.KSavedStateHandle
import com.taetae98.codelab.library.lifecycle.KViewModel
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonPrimitive
import org.koin.compose.getKoinScope
import org.koin.core.parameter.ParametersHolder
import kotlin.reflect.KClass

@Composable
public inline fun <reified T : KViewModel> ComponentContext.koinInject(): T {
    val isRegister = remember { mutableStateOf(false) }
    val scope = getKoinScope()
    val map = remember(this) {
        stateKeeper.consume(
            key = requireNotNull(getKClassForKViewModel<T>().simpleName),
            strategy = MapSerializer(String.serializer(), JsonPrimitive.serializer()),
        )?.toMutableMap() ?: mutableMapOf()
    }

    LaunchedEffect(this) {
        if (!isRegister.value) {
            stateKeeper.register(
                key = requireNotNull(getKClassForKViewModel<T>().simpleName),
                strategy = MapSerializer(String.serializer(), JsonPrimitive.serializer()),
                supplier = { map },
            )

            isRegister.value = true
        }
    }

    return remember(this, scope) {
        instanceKeeper.getOrCreate {
            scope.get(
                parameters = {
                    ParametersHolder(mutableListOf(KSavedStateHandle(map)))
                },
            )
        }
    }
}

public inline fun <reified T : KViewModel> getKClassForKViewModel(): KClass<T> {
    return T::class
}
