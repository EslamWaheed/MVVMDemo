package com.eslamwaheed.mvvmdemo.extensions

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView

//todo keep it for now
@SuppressLint("NotifyDataSetChanged")
fun <T : RecyclerView.ViewHolder, S> RecyclerView.Adapter<T>.setList(
    list: ArrayList<S>,
    clear: Boolean = false
) {
    if (clear) {
        list.clear()
    }

    this.notifyDataSetChanged()
}