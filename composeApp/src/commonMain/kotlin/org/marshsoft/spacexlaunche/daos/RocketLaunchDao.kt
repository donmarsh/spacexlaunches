package org.marshsoft.spacexlaunche.daos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import org.marshsoft.spacexlaunche.entities.RocketLaunch

@Dao
interface RocketLaunchDao {
    @Upsert
    suspend fun insert(rocketLaunch: RocketLaunch): Long
    @Upsert
    suspend fun insertAll(items: List<RocketLaunch>)

    @Query("SELECT * FROM rocketLaunch WHERE id = :id")
    suspend fun getRocketLaunchById(id: Int): RocketLaunch?

    @Delete
    suspend fun delete(rocketLaunch: RocketLaunch)

    @Query("DELETE FROM rocketLaunch WHERE id = :id")
    suspend fun deleteById(id: Int): Int

    @Query("SELECT * FROM rocketLaunch")
    fun getAllRocketLaunches(): Flow<List<RocketLaunch>>
    @Query("DELETE FROM rocketLaunch")
    suspend fun deleteAll()
}