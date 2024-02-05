package com.example.pexelssidorevichtestapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pexelssidorevichtestapp.R
import com.example.pexelssidorevichtestapp.adapters.BookmarksAdapter
import com.example.pexelssidorevichtestapp.ui.HomeScreenViewModel
import com.example.pexelssidorevichtestapp.ui.MainActivity
import org.w3c.dom.Text

class BookMarksFragment: Fragment(R.layout.bookmark_screen) {
    private lateinit var recycler : RecyclerView
    private lateinit var adapter : BookmarksAdapter
    private lateinit var viewModel : HomeScreenViewModel
    private lateinit var tv1: TextView
    private lateinit var tv2: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv1 = view.findViewById(R.id.textView3)
        tv2 = view.findViewById(R.id.textView4)



        recycler = view.findViewById(R.id.recyclerViewBookmarkScreen)
        viewModel = (activity as MainActivity).viewModel
        setupRecyclerView()

        viewModel.bookmarksList.observe(viewLifecycleOwner, Observer {
            if (viewModel.bookmarksList.value!!.isEmpty()) {
                recycler.visibility = View.GONE
            } else {
                tv1.visibility = View.GONE
                tv2.visibility = View.GONE
                recycler.visibility = View.VISIBLE
                adapter.differ.submitList(it)
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