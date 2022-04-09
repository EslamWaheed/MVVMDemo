package com.eslamwaheed.mvvmdemo.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.eslamwaheed.mvvmdemo.adapters.PhotosAdapter
import com.eslamwaheed.mvvmdemo.databinding.ActivityMainBinding
import com.eslamwaheed.mvvmdemo.viewmodels.UnsplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: UnsplashViewModel by viewModels()
    private lateinit var adapter: PhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        viewModel.searchPictures("flower")
        viewModel.unsplashSearchResponseLiveData.observe(this) {
            adapter = PhotosAdapter(it.results)
            binding.rvPhotos.adapter = adapter
        }
    }
}