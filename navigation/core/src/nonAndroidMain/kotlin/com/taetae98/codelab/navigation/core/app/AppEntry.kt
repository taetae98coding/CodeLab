package com.taetae98.codelab.navigation.core.app

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.taetae98.codelab.navigation.core.main.MainEntry
import com.taetae98.codelab.navigation.core.route.MainRoute
import com.taetae98.codelab.navigation.core.route.Route
import com.taetae98.codelab.navigation.core.route.WebViewRoute
import com.taetae98.codelab.navigation.core.webview.WebViewEntry

public class AppEntry(
    context: ComponentContext,
) {
    private val navigation = StackNavigation<Route>()

    public val stack: Value<ChildStack<*, Any>> = context.childStack(
        source = navigation,
        serializer = Route.serializer(),
        initialConfiguration = MainRoute,
        handleBackButton = true,
        childFactory = { route, context ->
            when (route) {
                is MainRoute -> MainEntry(
                    context = context,
                    onWebView = ::navigateToWebView,
                )

                is WebViewRoute -> WebViewEntry(
                    context = context,
                    onNavigateUp = navigation::pop,
                )
            }
        },
    )

    private fun navigateToWebView() {
        navigation.push(WebViewRoute)
    }
}
