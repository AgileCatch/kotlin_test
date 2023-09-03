package com.jess.camp.todo.add

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jess.camp.databinding.TodoAddActivityBinding
import com.jess.camp.todo.home.TodoModel


class TodoContentActivity : AppCompatActivity() {
    private lateinit var binding: TodoAddActivityBinding
    private var todoModel: TodoModel? = null // 아이템 정보를 저장할 변수 추가

    companion object {
        const val EXTRA_MODEL = "extra_model"


        fun newIntent(context: Context) = Intent(context, TodoContentActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TodoAddActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        todoModel = intent.getParcelableExtra(TodoContentActivity.EXTRA_MODEL)!!

        initView()

    }

    private fun initView() = with(binding) {
//        if (todoModel != null) {
//            // 아이템 정보가 있다면 해당 정보를 fab 등록 창에 표시
//            todoTitle.setText(todoModel?.title)
//            todoDescription.setText(todoModel?.description)
//        }

        toolBar.setNavigationOnClickListener {
            finish()
        }

        submit.setOnClickListener {
            val intent = Intent().apply {
                putExtra(
                    EXTRA_MODEL, TodoModel(
                        todoTitle.text.toString(), todoDescription.text.toString()
                    )
                )
            }
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
    //진입타입 설정
}