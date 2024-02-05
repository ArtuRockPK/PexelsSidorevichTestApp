package com.example.pexelssidorevichtestapp.repository

import com.example.pexelssidorevichtestapp.api.RetrofitInstance
import com.example.pexelssidorevichtestapp.db.PhotosDatabase

class PictureRepository(val db: PhotosDatabase) {
    suspend fun getPictures(searchWord:String, page:Int) =
        RetrofitInstance.api.getImages(typeOfPhotoFromTopRated = searchWord, numOfPage = page)
    suspend fun getChips() = RetrofitInstance.api.getTitles()
}