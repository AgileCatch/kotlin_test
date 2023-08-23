package com.example.view_binding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.view_binding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.button1.setOnClickListener {
            val view1= Intent(this@MainActivity,ListviewActivity::class.java)
            startActivity(view1)

        }

        binding.button2.setOnClickListener {
            val view2=Intent(this@MainActivity,GridviewActivity::class.java)
            startActivity(view2)
        }


    }
}