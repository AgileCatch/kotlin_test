package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.viewbinding.databinding.ActivityGridviewBinding

class ImgGridviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGridviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGridviewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.GridView.adapter = ImageAdaptor()

        // 항목 클릭 이벤트 처리
        binding.GridView.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(this@ImgGridviewActivity,"" + (position + 1) + "번째 선택",
                Toast.LENGTH_SHORT).show()
        }
    }
}