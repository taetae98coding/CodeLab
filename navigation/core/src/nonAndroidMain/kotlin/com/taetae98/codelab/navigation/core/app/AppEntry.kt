package com.taetae98.codelab.navigation.core.app

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.taetae98.codelab.navigation.core.datastore.DatastoreEntry
import com.taetae98.codelab.navigation.core.google.oauth.GoogleOAuthEntry
import com.taetae98.codelab.navigation.core.illegalRoute
import com.taetae98.codelab.navigation.core.main.MainEntry
import com.taetae98.codelab.navigation.core.memo.MemoEntry
import com.taetae98.codelab.navigation.core.poke.PokeEntry
import com.taetae98.codelab.navigation.core.route.DatastoreRoute
import com.taetae98.codelab.navigation.core.route.GoogleOAuthRoute
import com.taetae98.codelab.navigation.core.route.MainRoute
import com.taetae98.codelab.navigation.core.route.MemoRoute
import com.taetae98.codelab.navigation.core.route.PokeRoute
import com.taetae98.codelab.navigation.core.route.Route
import com.taetae98.codelab.navigation.core.route.WebViewRoute
import com.taetae98.codelab.navigation.core.webview.WebViewEntry

public class AppEntry(
    context: ComponentContext
) : ComponentContext by context {
    private val navigation = StackNavigation<Route>()

    public val stack: Value<ChildStack<*, ComponentContext>> = context.childStack(
        source = navigation,
        serializer = Route.serializer(),
        initialConfiguration = MainRoute,
        handleBackButton = true,
        childFactory = { route, context ->
            when (route) {
                MainRoute -> MainEntry(
                    context = context,
                    onWebView = ::navigateToWebView,
                    onMemo = ::navigateToMemo,
                    onPoke = ::navigateToPoke,
                    onDatastore = ::navigateToDatastore,
                    onGoogleOAuth = ::navigateToGoogleOAuth,
                )

                WebViewRoute -> WebViewEntry(
                    context = context,
                    onNavigateUp = navigation::pop
                )

                MemoRoute -> MemoEntry(
                    context = context,
                    onNavigateUp = navigation::pop
                )

                PokeRoute -> PokeEntry(
                    context = context,
                    onNavigateUp = navigation::pop
                )

                DatastoreRoute -> DatastoreEntry(
                    context = context,
                    onNavigateUp = navigation::pop
                )

                GoogleOAuthRoute -> GoogleOAuthEntry(
                    context = context,
                    onNavigateUp = navigation::pop,
                )

                else -> illegalRoute(route)
            }
        }
    )

    private fun navigateToWebView() {
        navigation.push(WebViewRoute)
    }

    private fun navigateToMemo() {
        navigation.push(MemoRoute)
    }

    private fun navigateToPoke() {
        navigation.push(PokeRoute)
    }

    private fun navigateToDatastore() {
        navigation.push(DatastoreRoute)
    }

    private fun navigateToGoogleOAuth() {
        navigation.push(GoogleOAuthRoute)
    }
}
