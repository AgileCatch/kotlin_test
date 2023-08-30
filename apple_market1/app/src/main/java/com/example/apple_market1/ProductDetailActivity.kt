package com.example.apple_market1

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
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
        val position = intent.getIntExtra("position", 0)
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
            if (product.isliked) {
                ivLike.setImageResource(R.drawable.heart_fill)
            } else {
                ivLike.setImageResource(R.drawable.heart)
            }

        }

        binding.btnBack.setOnClickListener {
            finish()
        }

        //좋아요버튼 클릭처리
        binding.ivLike.setOnClickListener {
            val product = productList[position]
            product.isliked = !product.isliked

            //버튼 클릭시 숫자도 올라가도록
            if(product.isliked){
                Toast.makeText(this,"관심목록에 추가되었습니다.", Toast.LENGTH_SHORT).show()
                product.like++
                binding.ivLike.setImageResource(R.drawable.heart_fill)
            }else {
                product.like--
                binding.ivLike.setImageResource(R.drawable.heart)
            }
            //좋아요 수를 메인으로 연결하기
            val intent = Intent()
            intent.putExtra("position", position)
            intent.putExtra("likeCount", product.like)
            setResult(Activity.RESULT_OK, intent)
        }
    }
}
