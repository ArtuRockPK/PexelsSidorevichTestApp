package com.example.pexelssidorevichtestapp.db

import androidx.room.TypeConverter
import com.example.pexelssidorevichtestapp.models.Photo
import com.google.gson.Gson
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {
    @TypeConverter
    fun fromPhoto(photo: Photo) : String {
        return Json.encodeToString(photo)
    }
    @TypeConverter
    fun toPhoto (photoString:String) : Photo {
        return Json.decodeFromString(photoString)
    }


}