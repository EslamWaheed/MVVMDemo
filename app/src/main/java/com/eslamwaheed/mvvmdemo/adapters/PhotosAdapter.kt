package com.eslamwaheed.mvvmdemo.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.eslamwaheed.mvvmdemo.data.models.entities.Photos
import com.eslamwaheed.mvvmdemo.databinding.PhotosItemBinding

class PhotosAdapter :
    PagingDataAdapter<Photos, PhotosAdapter.PhotosViewHolder>(PhotoDiffCallback()) {

    //private val list: ArrayList<Photos?> = arrayListOf()

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
        val photo = getItem(position)
        photo?.let { holder.bind(it) }
    }


    class PhotosViewHolder(private val binding: PhotosItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Photos) {
            binding.apply {
                list = item
                executePendingBindings()
            }
        }
    }

//    @SuppressLint("NotifyDataSetChanged")
//    fun setList(currentList: ArrayList<Photos?>, clear: Boolean = false) {
//        if (clear) {
//            list.clear()
//        }
//        list.addAll(currentList)
//        notifyDataSetChanged()
//    }
}

private class PhotoDiffCallback : DiffUtil.ItemCallback<Photos>() {
    override fun areItemsTheSame(oldItem: Photos, newItem: Photos): Boolean {
        return oldItem.result_id == newItem.result_id
    }

    override fun areContentsTheSame(oldItem: Photos, newItem: Photos): Boolean {
        return oldItem == newItem
    }
}