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
    private val adapter: PhotosAdapter by lazy { PhotosAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.unsplashSearchResponseLiveData.observe(this) {
            it?.photos?.let {
                adapter.setList(it)
                binding.rvPhotos.adapter = adapter
            }
        }
    }
}