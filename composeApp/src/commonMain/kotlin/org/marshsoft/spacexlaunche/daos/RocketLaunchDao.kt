package org.marshsoft.spacexlaunche.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import org.marshsoft.spacexlaunche.entities.RocketLaunch

@Dao
interface RocketLaunchDao {
    @Upsert
    suspend fun insert(rocketLaunch: RocketLaunch): Long

    @Query("SELECT * FROM rocketLaunch WHERE id = :id")
    suspend fun getRocketLaunchById(id: Int): RocketLaunch?

    @Delete
    suspend fun delete(rocketLaunch: RocketLaunch)

    @Query("DELETE FROM rocketLaunch WHERE id = :id")
    suspend fun deleteById(id: Int): Int

    @Query("SELECT * FROM rocketLaunch")
    suspend fun getAllRocketLaunches(): List<RocketLaunch>
}