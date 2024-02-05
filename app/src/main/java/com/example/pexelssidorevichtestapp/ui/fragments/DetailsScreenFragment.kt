package com.example.pexelssidorevichtestapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.pexelssidorevichtestapp.R
import com.example.pexelssidorevichtestapp.ui.HomeScreenViewModel
import com.example.pexelssidorevichtestapp.ui.MainActivity
import com.example.pexelssidorevichtestapp.ui.TAG
import kotlinx.coroutines.runBlocking

class DetailsScreenFragment : Fragment(R.layout.detail_screen){

    private lateinit var viewModel: HomeScreenViewModel
    private lateinit var saveBookmarksButton: Button

   // val args:DetailsScreenFragmentArgs by navArgs()

    lateinit var imageView:ImageView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        saveBookmarksButton= view.findViewById(R.id.save_to_bookmarks_button)





        saveBookmarksButton.setOnClickListener {
            runBlocking {
                val listPhotos = viewModel.bookmarksList.value!! + viewModel.detailsChoise.value!!
                viewModel.bookmarksList.postValue(listPhotos)
            }
        }


        viewModel = (activity as MainActivity).viewModel
        imageView = view.findViewById(R.id.imVDetailScreen)
        viewModel.detailsChoise.observe(viewLifecycleOwner, Observer { photos ->
            Glide.with(this).load(viewModel.detailsChoise.value?.src?.large2x).into(imageView)
        })






    }





}