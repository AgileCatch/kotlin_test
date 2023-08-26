package com.example.apple_market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apple_market.databinding.ActivityMainBinding
import com.example.apple_market.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}