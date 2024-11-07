package org.marshsoft.spacexlaunche

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.RoomDatabase
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.marshsoft.spacexlaunche.database.LaunchDatabase
import org.marshsoft.spacexlaunche.database.getRoomDatabase
import org.marshsoft.spacexlaunche.entities.RocketLaunch
import org.marshsoft.spacexlaunche.network.SpaceXApi
import org.marshsoft.spacexlaunche.repositories.LaunchRepository
import org.marshsoft.spacexlaunche.viewmodels.LaunchViewModel

@Composable
@Preview
fun App(  databaseBuilder: RoomDatabase.Builder<LaunchDatabase>) {
    val database = remember { getRoomDatabase(databaseBuilder) }
    val api = remember {SpaceXApi()}
    val repository = remember {LaunchRepository(database)}
    val launchViewModel = viewModel { LaunchViewModel(repository, api) }
    launchViewModel.retrieveLaunches()
    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
           MainContent(launchViewModel)
        }
    }
}
@Composable
fun MainContent(launchViewModel: LaunchViewModel){
    Text("Space X Launches", fontSize = 25.sp, modifier = Modifier.padding(10.dp))
    ScrollList(launchViewModel)

}
@Composable
fun ScrollList(launchViewModel: LaunchViewModel)
{
    val launches by launchViewModel.getLaunches().collectAsState(emptyList())
    LazyColumn (modifier = Modifier.fillMaxWidth()){
        items(launches){
            launch->
            ScrollListItem(launch)
        }
    }


}
@Composable
fun ScrollListItem(rocketLaunch: RocketLaunch)
{
    Card (modifier = Modifier.fillMaxWidth().padding(5.dp)){
        Column(modifier = Modifier.fillMaxWidth()){
            Text(rocketLaunch.missionName +" - "+ rocketLaunch.launchYear, fontSize = 20.sp)
            Text(if(rocketLaunch.launchSuccess == true) "Successful" else "Unsuccessful", color = if(rocketLaunch.launchSuccess==true) Color.Green else Color.Red)
            Text(rocketLaunch.details ?: "No Details")

        }
    }

}