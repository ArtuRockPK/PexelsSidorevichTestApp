package com.example.pexelssidorevichtestapp.ui.fragments

import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.pexelssidorevichtestapp.R
import com.example.pexelssidorevichtestapp.ui.HomeScreenViewModel
import com.example.pexelssidorevichtestapp.ui.MainActivity
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class DetailsScreenFragment : Fragment(R.layout.detail_screen) {

    private lateinit var viewModel: HomeScreenViewModel
    private lateinit var saveBookmarksButton: Button
    private lateinit var downloadButton: Button
    private lateinit var backToHome: ImageView
    private lateinit var descriptionTextView: TextView
    lateinit var imageView: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        saveBookmarksButton = view.findViewById(R.id.save_to_bookmarks_button)
        descriptionTextView = view.findViewById(R.id.textView2)
        backToHome = view.findViewById(R.id.back_to_home_screen)
        downloadButton = view.findViewById(R.id.downloadButton)
        backToHome.setOnClickListener {
            findNavController().popBackStack()
        }

        downloadButton.setOnClickListener {
            val image = imageView.drawable.toBitmap()
            val imageFile = viewModel.detailsChoise.value?.id.toString()
            MediaStore.Images.Media.insertImage(
                requireContext().contentResolver,
                image,
                imageFile,
                viewModel.detailsChoise.value?.photographer
                )
            Toast.makeText(context,"Image saved!",Toast.LENGTH_SHORT).show()
        }
        saveBookmarksButton.setOnClickListener {
            MainScope().launch {
                val listPhotos = viewModel.bookmarksList.value!! + viewModel.detailsChoise.value!!
                viewModel.bookmarksList.postValue(listPhotos)
            }
            Toast.makeText(context,"Saved to bookmarks",Toast.LENGTH_SHORT).show()
        }
        viewModel = (activity as MainActivity).viewModel
        imageView = view.findViewById(R.id.imVDetailScreen)
        viewModel.detailsChoise.observe(viewLifecycleOwner, Observer { photos ->
            Glide.with(this).load(viewModel.detailsChoise.value?.src?.portrait).into(imageView)
            descriptionTextView.text = viewModel.detailsChoise.value?.photographer

        })
    }
}








