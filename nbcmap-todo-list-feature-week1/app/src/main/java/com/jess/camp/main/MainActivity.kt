package com.jess.camp.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.jess.camp.R
import com.jess.camp.databinding.MainActivityBinding
import com.jess.camp.todo.TodoAddActivity
import com.jess.camp.todo.TodoModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding

    private val viewPagerAdapter by lazy {
        MainViewPagerAdapter(this@MainActivity)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // MainActivityBinding 클래스를 사용하여 XML 레이아웃을 바인딩합니다.
        binding = MainActivityBinding.inflate(layoutInflater)
        // 액티비티의 뷰를 바인딩된 레이아웃 루트뷰로 설정합니다.
        setContentView(binding.root)
        // 화면 초기화 메서드를 호출합니다.
        initView()
    }

    // 화면 초기화를 담당하는 메서드입니다.
    private fun initView() = with(binding) {
        toolBar.title = getString(R.string.app_name)
        // viewPager의 어댑터를 viewPagerAdapter로 설정합니다.
        viewPager.adapter = viewPagerAdapter

        // TabLayoutMediator를 사용하여 TabLayout과 ViewPager2를 연결합니다.
        // 탭을 생성하고, 각 탭에 대한 제목은 viewPagerAdapter에서 가져옵니다
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()

        // 2주차 선발대 과제 버튼 클릭시 추가하기
        fabAddTodo.setOnClickListener {
            viewPagerAdapter.launchAddTodoActivity()
        }


    }
    companion object {
        private const val ADD_TODO_REQUEST = 1
    }
}