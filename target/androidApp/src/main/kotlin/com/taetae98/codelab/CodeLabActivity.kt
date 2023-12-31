package com.taetae98.codelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.taetae98.codelab.app.AppEntry
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
internal class CodeLabActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppEntry()
        }
    }
}
