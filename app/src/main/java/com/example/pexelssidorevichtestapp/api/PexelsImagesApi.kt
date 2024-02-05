package com.example.pexelssidorevichtestapp.api

import com.example.pexelssidorevichtestapp.models.SearchResponse
import com.example.pexelssidorevichtestapp.models.TopCollections
import com.example.pexelssidorevichtestapp.util.Constants.Companion.MY_API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface PexelsImagesApi {

    @GET("v1/collections/featured")
    suspend fun getTitles(
        @Header("Authorization")
        myApiKey:String = MY_API_KEY,
        @Query("page")
        page:Int = 1,
        @Query("per_page")
        howManyOnPage:Int = 15
    ) : Response<TopCollections>

    @GET("v1/search")
    suspend fun getImages(
        @Header("Authorization")
        myApiKey:String = MY_API_KEY,
        @Query("query")
        typeOfPhotoFromTopRated:String = "Ocean",
        @Query("page")
        numOfPage:Int = 1,
        @Query("per_page")
        perPage:Int = 50
    ) : Response<SearchResponse>

}