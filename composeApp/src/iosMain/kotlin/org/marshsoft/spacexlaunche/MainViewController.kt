package org.marshsoft.spacexlaunche

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import org.marshsoft.spacexlaunche.database.getLaunchDatabaseIOS

fun MainViewController() = ComposeUIViewController {
    val database = remember { getLaunchDatabaseIOS() }

    App(database)
}