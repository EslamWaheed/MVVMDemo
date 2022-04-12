package com.eslamwaheed.mvvmdemo.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.eslamwaheed.mvvmdemo.adapters.PhotosAdapter
import com.eslamwaheed.mvvmdemo.databinding.FragmentPhotosBinding
import com.eslamwaheed.mvvmdemo.viewmodels.UnsplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosFragment : Fragment() {
    private lateinit var binding: FragmentPhotosBinding
    private val viewModel: UnsplashViewModel by viewModels()
    private val adapter: PhotosAdapter by lazy { PhotosAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPhotosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.unsplashSearchResponseLiveData.observe(viewLifecycleOwner) {
            it?.photos?.let {
                adapter.setList(it)
                binding.rvPhotos.adapter = adapter
            }
        }
    }
}