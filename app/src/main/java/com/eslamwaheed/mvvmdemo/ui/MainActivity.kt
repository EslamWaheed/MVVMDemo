package com.eslamwaheed.mvvmdemo.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.eslamwaheed.mvvmdemo.data.models.entities.Photos
import com.eslamwaheed.mvvmdemo.databinding.ActivityMainBinding
import com.google.gson.GsonBuilder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
        val photo = Photos(
            result_id = 0,
            width = 1,
            height = 2,
            description = "123",
            altDescription = "567",
            urls = null
        )
        Log.e("main", gson.toJson(photo))
    }
}