package org.marshsoft.spacexlaunche.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.marshsoft.spacexlaunche.network.SpaceXApi
import org.marshsoft.spacexlaunche.entities.RocketLaunch
import org.marshsoft.spacexlaunche.repositories.LaunchRepository

class LaunchViewModel(private val launchRepository: LaunchRepository, private val api:SpaceXApi):ViewModel() {

    fun getLaunches(): Flow<List<RocketLaunch>>
    {
        return launchRepository.getLaunches()
    }
    private suspend fun retrieveLaunchesSuspend()
    {

        val launches = api.getAllLaunches()
        launchRepository.insertAll(launches)
    }
    fun retrieveLaunches()
    {
        viewModelScope.launch {
            retrieveLaunchesSuspend()
        }

    }
}