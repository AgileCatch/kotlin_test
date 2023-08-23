package com.jess.camp.todo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jess.camp.databinding.TodoAddActivityBinding

class TodoAddActivity : AppCompatActivity() {

    private lateinit var binding: TodoAddActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TodoAddActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            val newTodoTitle = binding.title.text.toString()
            val newTodoContent = binding.content.text.toString()

            val intent = Intent()
            intent.putExtra("newTodoTitle", newTodoTitle)
            intent.putExtra("newTodoContent", newTodoContent)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}
