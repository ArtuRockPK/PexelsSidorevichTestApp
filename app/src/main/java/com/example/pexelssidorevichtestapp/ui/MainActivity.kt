package com.example.pexelssidorevichtestapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.ContactsContract.Contacts.Photo
import android.util.Log
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.allViews
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pexelssidorevichtestapp.R
import com.example.pexelssidorevichtestapp.adapters.PictureAdapter
import com.example.pexelssidorevichtestapp.api.RetrofitInstance
import com.example.pexelssidorevichtestapp.repository.PictureRepository
import com.example.pexelssidorevichtestapp.util.Resourse
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import kotlinx.coroutines.runBlocking

const val TAG = "lol"
class MainActivity : AppCompatActivity() {
    //lateinit var search: SearchView
    private lateinit var PictureAdapter: PictureAdapter
    private lateinit var Recycler: RecyclerView
    lateinit var viewModel: HomeScreenViewModel
    private lateinit var chipGroup: ChipGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vmFactory = HomeScreenVMProviderFactory(PictureRepository())
        viewModel = ViewModelProvider(this,vmFactory).get(HomeScreenViewModel::class.java)
        setContentView(R.layout.activity_main)




        ///val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

       // val navHost = findNavController(R.id.navigation)



    }



}