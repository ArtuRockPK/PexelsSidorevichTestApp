package com.example.pexelssidorevichtestapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.pexelssidorevichtestapp.R
import com.example.pexelssidorevichtestapp.models.Photo
import com.example.pexelssidorevichtestapp.ui.HomeScreenViewModel

class BookmarksAdapter :RecyclerView.Adapter<BookmarksAdapter.BookmarkViewHolder>() {
    private lateinit var viewModel: HomeScreenViewModel

    inner class BookmarkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallback = object : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.src.tiny == newItem.src.tiny
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return  oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        return BookmarkViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.home_screen_image_view,
                parent,
                false
            )
        )
    }



    override fun getItemCount(): Int {
        return differ.currentList.size

    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        val onePhotoObj = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(onePhotoObj.src.large2x).into(findViewById<ImageView>(R.id.imageViewItemViewBookmark))
            val authorNameSurname = findViewById<TextView>(R.id.ItemViewBookmarkAuthorName)
            authorNameSurname.text = onePhotoObj.photographer



            setOnClickListener {
                onItemClickListener?.let {
                    it(onePhotoObj)
                }
            }
        }
    }

    private var onItemClickListener: ((Photo) -> Unit)? = null

    fun setOnItemClicklistener(listener:(Photo) -> Unit) {
        onItemClickListener = listener
    }

}