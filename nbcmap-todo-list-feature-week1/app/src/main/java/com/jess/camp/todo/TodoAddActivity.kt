package com.jess.camp.todo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.jess.camp.R
import com.jess.camp.databinding.TodoAddActivityBinding

class TodoAddActivity : AppCompatActivity() {
    lateinit var binding: TodoAddActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = TodoAddActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //툴바 설정
        setSupportActionBar(binding.toolBar)
        val ab = supportActionBar!!
        ab.setDisplayShowTitleEnabled(true)
        ab.setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24)
        ab.setDisplayHomeAsUpEnabled(true)

        //사용자가 입력한 값을 저장하고, 이를 결과로 메인 화면에 전달하는 작업
        binding.btnAdd.setOnClickListener {
            val inputtitle = binding.title.text.toString()
            val inputcontent = binding.content.text.toString()

            val resultIntent = Intent()
            resultIntent.putExtra("title", inputtitle)
            resultIntent.putExtra("content", inputcontent)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}