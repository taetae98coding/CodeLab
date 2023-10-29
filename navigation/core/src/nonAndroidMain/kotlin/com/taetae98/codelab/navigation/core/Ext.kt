package com.taetae98.codelab.navigation.core

import com.taetae98.codelab.navigation.core.route.Route

internal inline fun illegalRoute(route: Route): Nothing {
    error("Illegal Route : $route")
}
