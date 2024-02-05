package com.example.pexelssidorevichtestapp.ui

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pexelssidorevichtestapp.models.Photo
import com.example.pexelssidorevichtestapp.models.SearchResponse
import com.example.pexelssidorevichtestapp.models.TopCollections
import com.example.pexelssidorevichtestapp.repository.PictureRepository
import com.example.pexelssidorevichtestapp.util.Resourse
import kotlinx.coroutines.launch
import retrofit2.Response

class HomeScreenViewModel(
    val PicRepository: PictureRepository
):ViewModel() {

    val myResponseWithPictures:MutableLiveData<Resourse<SearchResponse>> = MutableLiveData()
    val myResponseWithChips:MutableLiveData<Resourse<TopCollections>> = MutableLiveData()
    val bookmarksList:MutableLiveData<List<Photo>> = MutableLiveData(emptyList())
    init {
        getPhotos("Winter")
    }
    val detailsChoise: MutableLiveData<Photo> = MutableLiveData()
    fun getPhotos(tag:String) = viewModelScope.launch {

        val responsePics = PicRepository.getPictures(tag,1)
        val responseChips = PicRepository.getChips()

        myResponseWithPictures.postValue(handlePicResponse(responsePics))
        myResponseWithChips.postValue(handleChipResponse(responseChips))



    }

    private fun handlePicResponse(response: Response<SearchResponse>) : Resourse<SearchResponse> {
        if(response.isSuccessful) {
            response.body()?.let {resultResponse ->
                return Resourse.Success(resultResponse)
            }
        }
        return Resourse.Error(response.message())
    }
    private fun handleChipResponse(response: Response<TopCollections>) : Resourse<TopCollections> {
        if(response.isSuccessful) {
            response.body()?.let {resultResponse ->
                return Resourse.Success(resultResponse)
            }
        }
        return Resourse.Error(response.message())
    }





}