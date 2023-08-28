package com.example.apple_market

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.apple_market.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //툴바 설정
        setSupportActionBar(binding.toolBar)
        val ab = supportActionBar!!
//        ab.setDisplayShowTitleEnabled(true)

       // ab.setHomeAsUpIndicator(R.drawable.icon_notification)
        ab.setDisplayHomeAsUpEnabled(true)
    }

}