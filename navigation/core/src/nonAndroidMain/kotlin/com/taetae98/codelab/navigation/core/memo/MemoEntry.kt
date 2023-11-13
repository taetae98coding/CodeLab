package com.taetae98.codelab.navigation.core.memo

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.taetae98.codelab.navigation.core.illegalRoute
import com.taetae98.codelab.navigation.core.route.MemoAddRoute
import com.taetae98.codelab.navigation.core.route.MemoListRoute
import com.taetae98.codelab.navigation.core.route.Route

public class MemoEntry(
    context: ComponentContext,
    private val onNavigateUp: () -> Unit,
) : ComponentContext by context {
    private val navigation = StackNavigation<Route>()

    public val stack: Value<ChildStack<*, ComponentContext>> = context.childStack(
        source = navigation,
        serializer = Route.serializer(),
        initialConfiguration = MemoListRoute,
        handleBackButton = true,
    ) { route, context ->
        when (route) {
            MemoListRoute -> MemoListEntry(
                context = context,
                onNavigateUp = onNavigateUp,
                onNavigateToMemoAdd = ::navigateToMemoAdd,
            )

            MemoAddRoute -> MemoAddEntry(
                context = context,
                onNavigateUp = navigation::pop,
            )

            else -> illegalRoute(route)
        }
    }

    private fun navigateToMemoAdd() {
        navigation.push(MemoAddRoute)
    }
}
