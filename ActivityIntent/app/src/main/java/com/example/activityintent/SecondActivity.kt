package com.example.activityintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val btn=findViewById<Button>(R.id.btn_close)
        btn.setOnClickListener {
            finish()
        }
    }
}