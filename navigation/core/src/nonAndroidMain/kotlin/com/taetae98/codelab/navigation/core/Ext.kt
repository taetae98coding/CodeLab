package com.taetae98.codelab.navigation.core

import com.taetae98.codelab.navigation.core.route.Route

internal fun illegalRoute(route: Route) {
    error("Illegal Route : $route")
}
