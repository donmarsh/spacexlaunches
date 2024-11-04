package org.marshsoft.spacexlaunche.database

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.marshsoft.spacexlaunche.entities.Links

class Converters {
    @TypeConverter
    fun fromListLinks(value : List<Links>) = Json.encodeToString(value)

    @TypeConverter
    fun toLinksList(value: String) = Json.decodeFromString<List<Links>>(value)

}