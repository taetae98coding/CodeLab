package com.taetae98.codelab.feature.datastore

internal data class DatastoreUiState(
    val value: String,
    val setValue: (String) -> Unit,
)