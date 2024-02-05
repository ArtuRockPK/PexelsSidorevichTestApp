package com.example.pexelssidorevichtestapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.pexelssidorevichtestapp.models.Photo


@Database(
    entities = [Photo::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class PhotosDatabase : RoomDatabase() {
    abstract fun getPhotosDao(): PhotoDao
    companion object {
        @Volatile
        private var instance: PhotosDatabase? = null

        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it}

        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                PhotosDatabase::class.java,
                "photos.db"
            ).build()
    }







}