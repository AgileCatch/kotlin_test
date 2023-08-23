package com.example.view_binding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.view_binding.databinding.ActivityGirdviewBinding

class GridviewActivity : AppCompatActivity() {
    private lateinit var binding :ActivityGirdviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityGirdviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ImageAdapter 객체를 생성하고 GridView 객체에 연결
        binding.gridvew.adapter = ImageAdapter()


    }
}