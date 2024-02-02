package com.example.pexelssidorevichtestapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.pexelssidorevichtestapp.R
import com.example.pexelssidorevichtestapp.ui.HomeScreenViewModel
import com.example.pexelssidorevichtestapp.ui.MainActivity
import com.example.pexelssidorevichtestapp.ui.TAG

class DetailsScreenFragment : Fragment(R.layout.detail_screen){

    private lateinit var viewModel: HomeScreenViewModel
   // val args:DetailsScreenFragmentArgs by navArgs()

    lateinit var imageView:ImageView


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel


            // val data = args.argHomeScreen
        //Log.d(TAG,data.toString())
        imageView = view.findViewById(R.id.imVDetailScreen)

        viewModel.detailsChoise.observe(viewLifecycleOwner, Observer { photos ->
            Glide.with(this).load(viewModel.detailsChoise.value?.src?.large2x).into(imageView)
        })






    }





}