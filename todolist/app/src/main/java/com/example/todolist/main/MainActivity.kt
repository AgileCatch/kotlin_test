package com.example.todolist.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist.databinding.MainActivityBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    private val viewPagerAdapter by lazy {
        MainViewPagerAdapter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    //초기화 블록 선언
    private fun initView() {
        binding.toolBar.title="앱이름"//Stirng res사용하기

        //view pager adapter
        binding.viewPager.adapter = viewPagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text=viewPagerAdapter.getTitle(position)
        }.attach()

        //할 일 추가버튼
        binding.fabAddTodo.setOnClickListener {
            //
        }
    }
}