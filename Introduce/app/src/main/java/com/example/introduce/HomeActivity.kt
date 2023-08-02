package com.example.introduce

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //데이터 받아오기
        val data_name =intent.getStringExtra("name Data")
        val data_id =intent.getStringExtra("Id Data")

        val edit_name=findViewById<TextView>(R.id.homeId)
        val edit_id=findViewById<TextView>(R.id.homeName)

        edit_name.setText(data_name)
        edit_id.setText(data_id)

        //화면 종료
        val btn_close=findViewById<Button>(R.id.close)
        btn_close.setOnClickListener {
            finish()
        }
    }
}