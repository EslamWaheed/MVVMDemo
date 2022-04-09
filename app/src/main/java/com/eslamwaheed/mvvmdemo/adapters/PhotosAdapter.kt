package com.eslamwaheed.mvvmdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eslamwaheed.mvvmdemo.data.UnsplashSearchResponse
import com.eslamwaheed.mvvmdemo.databinding.PhotosItemBinding

class PhotosAdapter(private val list: List<UnsplashSearchResponse.Result?>?) :
    RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        return PhotosViewHolder(
            PhotosItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photo = list?.get(position)
        photo?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return if (list?.isNotEmpty() == true) list.size else 0
    }

    class PhotosViewHolder(private val binding: PhotosItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UnsplashSearchResponse.Result) {
            binding.apply {
                list = item
                executePendingBindings()
            }
        }
    }
}