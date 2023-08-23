package com.example.viewbinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMain.setOnClickListener {
            binding.tvMain.text = "바인딩이 잘 되었습니다 !"
        }

        binding.btnLv.setOnClickListener {
            val view1 = Intent(this@MainActivity,ListviewActivity::class.java)
            startActivity(view1)
        }

        binding.btnGv.setOnClickListener {
            val view2 = Intent(this@MainActivity,ImgGridviewActivity::class.java)
            startActivity(view2)
        }


    }
}