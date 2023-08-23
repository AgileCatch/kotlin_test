package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.viewbinding.databinding.ActivityGridviewBinding

class ImgGridviewActivity : AppCompatActivity() {

    private lateinit var GVbinding : ActivityGridviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        GVbinding = ActivityGridviewBinding.inflate(layoutInflater)
        setContentView(GVbinding.root)


        GVbinding.GridView.adapter = ImageAdaptor()

        // 항목 클릭 이벤트 처리
        GVbinding.GridView.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(this@ImgGridviewActivity,"" + (position + 1) + "번째 선택",
                Toast.LENGTH_SHORT).show()
        }
    }
}