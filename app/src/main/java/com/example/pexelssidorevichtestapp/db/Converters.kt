package com.example.pexelssidorevichtestapp.db

import androidx.room.TypeConverter
import com.example.pexelssidorevichtestapp.models.Photo
import com.example.pexelssidorevichtestapp.models.SrcX
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
    @TypeConverter
    fun fromSrcX(sourse: SrcX) : String {
        return Json.encodeToString(sourse)
    }
    @TypeConverter
        fun toSrcX(srcxString: String) : SrcX {
            return Json.decodeFromString(srcxString)
        }





}