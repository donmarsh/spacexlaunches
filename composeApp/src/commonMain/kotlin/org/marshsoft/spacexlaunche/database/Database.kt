package org.marshsoft.spacexlaunche.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import androidx.room.TypeConverters
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import org.marshsoft.spacexlaunche.daos.RocketLaunchDao
import org.marshsoft.spacexlaunche.entities.RocketLaunch

@Database(entities = [RocketLaunch::class], version = 1)
@ConstructedBy(LaunchDatabaseConstructor::class)
@TypeConverters(Converters::class)
abstract class LaunchDatabase: RoomDatabase() {
    abstract fun rocketLaunchDao(): RocketLaunchDao
}
// The Room compiler generates the `actual` implementations.
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object LaunchDatabaseConstructor : RoomDatabaseConstructor<LaunchDatabase> {
    override fun initialize(): LaunchDatabase
}
fun getRoomDatabase(
    builder: RoomDatabase.Builder<LaunchDatabase>
): LaunchDatabase {
    return builder
        .fallbackToDestructiveMigrationOnDowngrade(true)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}

