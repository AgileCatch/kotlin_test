package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 데이터 원본 준비
        val dataList = mutableListOf<MyItem>()
        dataList.add(MyItem(R.drawable.cat, "Bella", "1"))
        dataList.add(MyItem(R.drawable.cat1, "Charlie", "2"))
        dataList.add(MyItem(R.drawable.cat2, "Daisy", "1.5"))
        dataList.add(MyItem(R.drawable.cat3, "Duke", "1"))
        dataList.add(MyItem(R.drawable.cat4, "Max", "2"))
        dataList.add(MyItem(R.drawable.cat5, "Happy", "4"))
        dataList.add(MyItem(R.drawable.cat6, "Luna", "3"))
        dataList.add(MyItem(R.drawable.cat7, "Bob", "2"))

        binding.recyclerView.adapter = MyAdapter(dataList)

        val adapter = MyAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : MyAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val name: String = dataList[position].aName
                Toast.makeText(this@MainActivity," $name 선택!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}