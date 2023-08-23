package com.example.view_binding

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.view_binding.databinding.ActivityListviewBinding

class ListviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListviewBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //데이터 원본준비
        val items =
            arrayOf<String?>("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8")

        //어댑터 준비(배열 객체 이용,simple_list_item_1 리소스 사용)
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, items)

        //어댑터를 listview객체에 연결
        binding.listview.adapter = adapter

    }
}