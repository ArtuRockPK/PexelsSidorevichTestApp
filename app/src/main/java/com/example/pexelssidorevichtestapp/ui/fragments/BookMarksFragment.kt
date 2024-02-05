package com.example.pexelssidorevichtestapp.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pexelssidorevichtestapp.R
import com.example.pexelssidorevichtestapp.adapters.BookmarksAdapter
import com.example.pexelssidorevichtestapp.ui.HomeScreenViewModel
import com.example.pexelssidorevichtestapp.ui.MainActivity

class BookMarksFragment: Fragment(R.layout.bookmark_screen) {
    private lateinit var recycler : RecyclerView
    private lateinit var adapter : BookmarksAdapter
    private lateinit var viewModel : HomeScreenViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        viewModel.bookmarksList.observe(viewLifecycleOwner, Observer {
            if (viewModel.bookmarksList.value!!.isEmpty()) {
                recycler.visibility = View.GONE
            }
        })
    }
    private fun setupRecyclerView() {
        adapter = BookmarksAdapter()
        recycler.apply {
            adapter = BookmarksAdapter()
            layoutManager = StaggeredGridLayoutManager(2,1)
        }
    }

}