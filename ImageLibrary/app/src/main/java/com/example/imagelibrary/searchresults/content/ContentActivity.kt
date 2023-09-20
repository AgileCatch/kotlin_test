package com.example.imagelibrary.searchresults.content

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imagelibrary.databinding.ActivityContentBinding

class ContentActivity : AppCompatActivity() {

private lateinit var binding: ActivityContentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        TODO("Not yet implemented")
    }
}