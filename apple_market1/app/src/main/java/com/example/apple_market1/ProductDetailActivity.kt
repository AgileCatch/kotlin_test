package com.example.apple_market1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apple_market1.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding= ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Intent로부터 데이터 받기
        val seller = intent.getStringExtra("seller")
        val address = intent.getStringExtra("address")
        val productName = intent.getStringExtra("productName")
        val productImg = intent.getIntExtra("productImg", 0)
        val introduction = intent.getStringExtra("introduction")
        val price = intent.getStringExtra("price")

        // 받은 데이터를 활용하여 디테일 화면 구성
        binding.tvSeller.text = seller
        binding.tvAddress.text = address
        binding.tvProductName.text = productName
        binding.imageView.setImageResource(productImg)
        binding.tvIntroduction.text = introduction
        binding.tvPrice.text = price
    }
}