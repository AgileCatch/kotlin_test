package com.example.viewbinding

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.viewbinding.databinding.ActivityListviewBinding
import java.util.zip.Inflater

class ListviewActivity : AppCompatActivity() {

    private lateinit var LVbinding : ActivityListviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        LVbinding = ActivityListviewBinding.inflate(layoutInflater)
        setContentView(LVbinding.root)

        // 데이터 원본 준비
        val items = arrayOf<String?>("item1", "item2", "item3", "item4", "item5", "item6", "item7", "item8", "item5", "item6", "item7", "item8", "item5", "item6", "item7", "item8", "item5", "item6",  "item7", "item8")

        //어댑터 준비 (배열 객체 이용, simple_list_item_1 리소스 사용)
        val adapter = ArrayAdapter(this, R.layout.simple_list_item_1, items)

        //ListView 객체에 어댑터 연결
        LVbinding.ListView.adapter = adapter

    }
}