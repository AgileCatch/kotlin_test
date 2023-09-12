package com.example.todolist.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todolist.bookmark.BookMarkListAdapter
import com.example.todolist.bookmark.BookMarkModel
import com.example.todolist.databinding.TodolistFragmentBinding

class TodoListFragment : Fragment() {
    //static 함수를 사용하여 todolist Fragment를 가져올 수 있는 instance를 만들어줌
    companion object {
        fun newInstance() = TodoListFragment()
    }

    private var _binding:
            TodolistFragmentBinding? = null
    private val binding get()=_binding!!

    //리사이클러뷰어댑터 연결
    private val recyclerViewAdapter by lazy {
        TodoListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //바인딩을 넣어줘야함
        _binding=TodolistFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.todoList.adapter = recyclerViewAdapter

        //test data
        val list = ArrayList<TodoModel>()
        for (i in 0..100) {
            list.add(TodoModel("todo  $i"))
        }
        recyclerViewAdapter.addItems(list)
    }

    //바인딩을 위해 메모리 누수를 위해 강제적으로 초기화시켜줘야함
    override fun onDestroyView() {
        _binding=null
        super.onDestroyView()
    }
}