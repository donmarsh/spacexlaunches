package org.marshsoft.spacexlaunche.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

fun getLaunchDatabaseAndroid(context: Context): RoomDatabase.Builder<LaunchDatabase> {
    val dbFile = context.getDatabasePath("launches.db")
    return Room.databaseBuilder<LaunchDatabase>(
        context = context.applicationContext,
        name = dbFile.absolutePath
    )
}
