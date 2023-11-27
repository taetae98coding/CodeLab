package com.taetae98.codelab.navigation.core.datastore

import com.arkivanov.decompose.ComponentContext

public class DatastoreEntry(
    context: ComponentContext,
    public val onNavigateUp: () -> Unit,
) : ComponentContext by context