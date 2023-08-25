package com.example.registerforactivityresult

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.registerforactivityresult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val getResult=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){reslut ->
        if (reslut.resultCode == RESULT_OK) {
            val data = reslut.data
            val receivedText=data?.getStringExtra("text")
            Toast.makeText(this,"$receivedText",Toast.LENGTH_SHORT).show()

            val mainText = findViewById<TextView>(R.id.tv_received)
            mainText.text = receivedText.toString()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSecond.setOnClickListener {
            val intent=Intent(this@MainActivity,SecondActivity::class.java)
            getResult.launch(intent)

        }
    }
}