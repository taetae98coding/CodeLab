package com.taetae98.codelab.navigation.core.poke

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.taetae98.codelab.navigation.core.illegalRoute
import com.taetae98.codelab.navigation.core.route.PokeListRoute
import com.taetae98.codelab.navigation.core.route.Route

public class PokeEntry(
    context: ComponentContext,
    private val onNavigateUp: () -> Unit,
) : ComponentContext by context {
    private val navigation = StackNavigation<Route>()

    public val stack: Value<ChildStack<*, ComponentContext>> = context.childStack(
        source = navigation,
        serializer = Route.serializer(),
        initialConfiguration = PokeListRoute,
        handleBackButton = true,
    ) { route, context ->
        when (route) {
            PokeListRoute -> PokeListEntry(
                context = context,
                onNavigateUp = onNavigateUp,
            )

            else -> illegalRoute(route)
        }
    }
}
