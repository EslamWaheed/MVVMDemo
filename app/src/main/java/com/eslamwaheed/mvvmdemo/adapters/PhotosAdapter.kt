package com.eslamwaheed.mvvmdemo.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eslamwaheed.mvvmdemo.data.models.UnsplashSearchResponse
import com.eslamwaheed.mvvmdemo.databinding.PhotosItemBinding

class PhotosAdapter : RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    private val list: ArrayList<UnsplashSearchResponse.Photos?> = arrayListOf()

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
        val photo = list[position]
        photo?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return if (list.isNotEmpty()) list.size else 0
    }

    class PhotosViewHolder(private val binding: PhotosItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: UnsplashSearchResponse.Photos) {
            binding.apply {
                list = item
                executePendingBindings()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(currentList: ArrayList<UnsplashSearchResponse.Photos?>, clear: Boolean = false) {
        if (clear) {
            list.clear()
        }
        list.addAll(currentList)
        notifyDataSetChanged()
    }
}