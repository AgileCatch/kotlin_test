package com.example.viewbinding

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.viewbinding.databinding.ActivityListviewBinding
import java.util.zip.Inflater

class ListviewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListviewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 원본 준비
        //데이터원본준비
        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(com.example.viewbinding.R.drawable.cat1, "Bella", "1"))
        dataList.add(MyItem(com.example.viewbinding.R.drawable.cat2, "Charlie", "2"))
        dataList.add(MyItem(com.example.viewbinding.R.drawable.cat3, "Daisy", "1.5"))
        dataList.add(MyItem(com.example.viewbinding.R.drawable.cat4, "Duke", "1"))
        dataList.add(MyItem(com.example.viewbinding.R.drawable.cat5, "Max", "2"))
        dataList.add(MyItem(com.example.viewbinding.R.drawable.cat6, "Happy", "4"))
        dataList.add(MyItem(com.example.viewbinding.R.drawable.cat7, "Luna", "3"))
        dataList.add(MyItem(com.example.viewbinding.R.drawable.cat8, "Bob", "2"))

        //어댑터 생성 및 연결
        binding.ListView.adapter = MyAdapter(this, dataList)


        // 항목 클릭 이벤트 처리
        binding.ListView.setOnItemClickListener { parent, view, position, id ->
            val name: String = (binding.ListView.adapter.getItem(position) as MyItem).aName
            Toast.makeText(this, " $name 선택!", Toast.LENGTH_SHORT).show()// 항목 클릭 이벤트 처리
            binding.ListView.setOnItemClickListener { parent, view, position, id ->
                val name: String = (binding.ListView.adapter.getItem(position) as MyItem).aName
                Toast.makeText(this, " $name 선택!", Toast.LENGTH_SHORT).show()

            }
        }
    }
}