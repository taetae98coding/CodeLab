package com.taetae98.codelab.navigation.compose.datastore

import androidx.navigation.NavController
import com.taetae98.codelab.navigation.core.datastore.DataStoreEntry

public fun NavController.navigateToDataStore() {
    navigate(DataStoreEntry.ROUTE)
}
