package org.marshsoft.spacexlaunche.repositories

import kotlinx.coroutines.flow.Flow
import org.marshsoft.spacexlaunche.daos.RocketLaunchDao
import org.marshsoft.spacexlaunche.database.LaunchDatabase
import org.marshsoft.spacexlaunche.entities.RocketLaunch

class LaunchRepository(private val database: LaunchDatabase) {
    private val launchDao:RocketLaunchDao = database.rocketLaunchDao()
    suspend fun insertLaunch(rocketLaunch: RocketLaunch) {
        launchDao.insert(rocketLaunch);
    }

    suspend fun deleteLaunch(rocketLaunch: RocketLaunch) {
        launchDao.delete(rocketLaunch)
    }

    fun getLaunches(): Flow<List<RocketLaunch>>
    {
        return launchDao.getAllRocketLaunches();
    }
    suspend fun getLaunch(id:Int)
    {
        launchDao.getRocketLaunchById(id);
    }
    suspend fun deleteAll()
    {
        launchDao.deleteAll()
    }
    suspend fun insertAll(launches: List<RocketLaunch>)
    {
        launchDao.insertAll(launches)
    }
}