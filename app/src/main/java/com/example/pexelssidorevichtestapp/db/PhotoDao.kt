package com.example.pexelssidorevichtestapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pexelssidorevichtestapp.models.Photo
@Dao
interface PhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Photo) : Long
    @Query("SELECT * FROM photos")
    fun getAllPhotos(): LiveData<List<Photo>>
    @Delete
    suspend fun deletePhoto(photo: Photo)
}