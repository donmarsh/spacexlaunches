package org.marshsoft.spacexlaunche

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import org.marshsoft.spacexlaunche.database.getLaunchDatabaseAndroid

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = getLaunchDatabaseAndroid(applicationContext)

        setContent {
            App(database)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    val context = LocalContext.current
    val database = getLaunchDatabaseAndroid(context)
    App(database)
}