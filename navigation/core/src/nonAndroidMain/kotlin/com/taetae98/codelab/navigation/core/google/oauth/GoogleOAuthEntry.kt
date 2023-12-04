package com.taetae98.codelab.navigation.core.google.oauth

import com.arkivanov.decompose.ComponentContext

public class GoogleOAuthEntry(
    context: ComponentContext,
    public val onNavigateUp: () -> Unit,
) : ComponentContext by context