package com.taetae98.codelab.navigation.core.memo

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.taetae98.codelab.navigation.core.Entry
import com.taetae98.codelab.navigation.core.illegalRoute
import com.taetae98.codelab.navigation.core.route.MemoListRoute
import com.taetae98.codelab.navigation.core.route.MemoRoute
import com.taetae98.codelab.navigation.core.route.Route

public class MemoEntry(
    context: ComponentContext,
    public val onNavigateUp: () -> Unit,
) : Entry() {
    private val navigation = StackNavigation<Route>()

    public val stack: Value<ChildStack<*, Entry>> = context.childStack(
        source = navigation,
        serializer = Route.serializer(),
        initialConfiguration = MemoListRoute,
        handleBackButton = true,
    ) { route, context ->
        when (route) {
            MemoListRoute -> MemoListEntry()
            else -> illegalRoute(route)
        }
    }

    public fun navigateToMemoAdd() {

    }

    public fun navigateToTagAdd() {

    }
}