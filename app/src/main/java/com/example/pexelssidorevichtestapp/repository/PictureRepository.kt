package com.example.pexelssidorevichtestapp.repository

import com.example.pexelssidorevichtestapp.api.RetrofitInstance

class PictureRepository {

    suspend fun getPictures(searchWord:String, page:Int) =
        RetrofitInstance.api.getImages(typeOfPhotoFromTopRated = searchWord, numOfPage = page)

    suspend fun getChips() = RetrofitInstance.api.getTitles()
}