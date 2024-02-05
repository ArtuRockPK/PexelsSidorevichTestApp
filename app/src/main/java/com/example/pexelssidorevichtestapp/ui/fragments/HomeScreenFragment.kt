package com.example.pexelssidorevichtestapp.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup.LayoutParams
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pexelssidorevichtestapp.R
import com.example.pexelssidorevichtestapp.adapters.PictureAdapter
import com.example.pexelssidorevichtestapp.ui.HomeScreenViewModel
import com.example.pexelssidorevichtestapp.ui.MainActivity
import com.example.pexelssidorevichtestapp.util.Resourse
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout.Tab

class HomeScreenFragment : Fragment(R.layout.home_screen) {

    private lateinit var bookmarsTab: Tab
    private lateinit var PictureAdapter: PictureAdapter
    private lateinit var Recycler: RecyclerView
    private lateinit var viewModel: HomeScreenViewModel
    private lateinit var chipGroup: ChipGroup
    val TAG = "sometag"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        Recycler = view.findViewById(R.id.recycler_view_1)
        chipGroup = view.findViewById(R.id.chipGroup)
        chipGroup.isScrollContainer = true
        setupRecyclerView()

        PictureAdapter.setOnItemClicklistener {

            val bundle = Bundle().apply {
                putSerializable("someKey",it)
            }

            view.findNavController().navigate(R.id.action_homeScreenFragment_to_detailsScreenFragment,bundle)
            viewModel.detailsChoise.postValue(it)

        }

        viewModel.myResponseWithChips.observe(viewLifecycleOwner, Observer{ response->
            when(response) {
                is Resourse.Success -> {
                    response.data?.let {
                        for(i in 0..6) {
                            addChip(response.data.collections[i].title)
                        }
                    }
                }
                is Resourse.Error -> {
                    Toast.makeText(context,"${response.message}", Toast.LENGTH_SHORT)
                }
                is Resourse.Loading -> {
                }
            }
        })

        viewModel.myResponseWithPictures.observe(viewLifecycleOwner,Observer { response->

            when(response) {
                is Resourse.Success -> {
                    response.data?.let {
                        PictureAdapter.differ.submitList(it.photos)
                    }
                }
                is Resourse.Error -> {
                    Toast.makeText(context,"${response.message}",Toast.LENGTH_SHORT)
                }
                is Resourse.Loading -> {
                }
            }
        })

    }

    private fun setupRecyclerView() {
        PictureAdapter = PictureAdapter()
        Recycler.apply {
            adapter = PictureAdapter
            layoutManager = StaggeredGridLayoutManager(2,1)
        }
    }

    private fun addChip(message: String) {
        val chip = Chip(context)
        chip.setChipBackgroundColorResource(R.color.white)
        chip.setChipStrokeColorResource(R.color.white)
        chip.setTextSize(18f)
        chip.setChipCornerRadiusResource(R.dimen.chipConerRadius)
        chip.text = message
        chipGroup.addView(chip)
        chip.setOnClickListener {
            Toast.makeText(context,chip.text,Toast.LENGTH_SHORT).show()
            chipGroup.clearCheck()
            chipGroup.check(chip.id)
            if(chip.isChecked) chip.setChipBackgroundColorResource(R.color.red) else chip.setChipBackgroundColorResource(R.color.white)
        }

   }


}