package com.example.customview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.customview.databinding.ActivityMainBinding

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


        // 어댑터 생성 및 연결
        binding.listView.adapter = MyAdapter(this, dataList)

        // 항목 클릭 이벤트 처리
        binding.listView.setOnItemClickListener{ parent, view, position, id ->
            val name: String = (binding.listView.adapter.getItem(position) as MyItem).aName
            Toast.makeText(this," $name 선택!", Toast.LENGTH_SHORT).show()
        }
    }
}