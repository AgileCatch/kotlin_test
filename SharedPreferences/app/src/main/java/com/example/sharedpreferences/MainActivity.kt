package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            saveData()
            Toast.makeText(this,"데이터 저장",Toast.LENGTH_SHORT).show()
        }
        loadData()
    }

    private fun loadData() {
        val pref= getSharedPreferences("pref",0)
        binding.editText.setText(pref.getString("name",""))
    }

    private fun saveData() {
        val pref= getSharedPreferences("pref",0)
        val edit=pref.edit()
        edit.putString("name",binding.editText.text.toString())
        edit.apply()
    }

} 