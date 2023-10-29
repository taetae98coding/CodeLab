package com.taetae98.codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.SavedStateHandle
import com.taetae98.codelab.app.AppEntry
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class CodeLabActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        SavedStateHandle
        super.onCreate(savedInstanceState)
        setContent {
            AppEntry()
        }
    }
}
