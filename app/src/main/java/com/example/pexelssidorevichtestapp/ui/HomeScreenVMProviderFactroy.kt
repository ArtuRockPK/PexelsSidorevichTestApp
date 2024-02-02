package com.example.pexelssidorevichtestapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pexelssidorevichtestapp.repository.PictureRepository

class HomeScreenVMProviderFactory(
    val pictureRepository: PictureRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create (modelClass: Class<T>): T {
        return HomeScreenViewModel(pictureRepository) as T
    }

}