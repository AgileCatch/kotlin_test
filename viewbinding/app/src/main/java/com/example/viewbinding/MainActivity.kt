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
        val view = binding.root
        setContentView(view)

        binding.btnMain.setOnClickListener {
            binding.tvMain.text = "바인딩이 잘 되었습니다 :)"
        }

        binding.btnLv.setOnClickListener {
            val intentLV = Intent(this@MainActivity,ListviewActivity::class.java)
            startActivity(intentLV)
        }

        binding.btnGv.setOnClickListener {
            val intentGV = Intent(this@MainActivity,ImgGridviewActivity::class.java)
            startActivity(intentGV)
        }


    }
}