package org.marshsoft.spacexlaunche

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.RoomDatabase
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.marshsoft.spacexlaunche.database.LaunchDatabase
import org.marshsoft.spacexlaunche.entities.RocketLaunch
import org.marshsoft.spacexlaunche.viewmodels.LaunchViewModel

@Composable
@Preview
fun App(  databaseBuilder: RoomDatabase.Builder<LaunchDatabase>) {
    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
           MainContent()
        }
    }
}
@Composable
fun MainContent(){
    val launchViewModel = viewModel { LaunchViewModel() }
    Text("SpaceX Launches")
    Button(onClick = { launchViewModel.getLaunches() }) {
        Text("Reload Launches")
    }
    ScrollList()

}
@Composable
fun ScrollList()
{

}
@Composable
fun ScrollListItem(rocketLaunch: RocketLaunch)
{
    Column(modifier = Modifier.fillMaxWidth()){
        Text(rocketLaunch.missionName +" - "+ rocketLaunch.launchYear, fontSize = 30.sp)
        Text(if(rocketLaunch.launchSuccess == true) "Successful" else "Unsuccessful", color = if(rocketLaunch.launchSuccess==true) Color.Green else Color.Red)
        Text(rocketLaunch.details ?: "No Details")

    }
}