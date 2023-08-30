package com.example.apple_market1

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.apple_market1.ProductSingleton.productList
import com.example.apple_market1.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Intent로부터 데이터 받기
        val position=intent.getIntExtra("position",0)
        val product = productList[position]

        val seller = product.seller
        val address = product.address
        val productName = product.productName
        val productImg = product.productImg
        val introduction = product.introduction
        val price = formatPrice(product.price)

        // 받은 데이터를 활용하여 디테일 화면 구성
        binding.apply {
            tvSeller.text = seller
            tvAddress.text = address
            tvProductName.text = productName
            imageView.setImageResource(productImg)
            tvIntroduction.text = introduction
            tvPrice.text = price
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}
