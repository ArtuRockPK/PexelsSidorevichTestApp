package com.example.pexelssidorevichtestapp.ui.fragments

import android.media.Image
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pexelssidorevichtestapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class StartScreenFragment: Fragment(R.layout.start_screen) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }
    override fun onResume() {
        super.onResume()
        MainScope().launch{
            delay(2000L)
            findNavController().navigate(R.id.action_startScreenFragment_to_homeScreenFragment)
        }
    }
}