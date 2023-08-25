package com.jess.camp.main

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayoutMediator
import com.jess.camp.R
import com.jess.camp.databinding.MainActivityBinding
import com.jess.camp.todo.TodoAddActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private lateinit var fabAddTodo: FloatingActionButton

    private val viewPagerAdapter by lazy {
        MainViewPagerAdapter(this@MainActivity)
    }

    private val ResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val title = data?.getStringExtra("title")
                val content = data?.getStringExtra("content")

                // TodoFragment에 title과 content를 전달
                val todoFragment = viewPagerAdapter.getFragment()
                todoFragment.handleInput(title, content)
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //버튼 클릭시 숨김처리
        fabAddTodo = binding.fabAddTodo

        // 화면 초기화 메서드를 호출합니다.
        initView()

    }

    // 화면 초기화를 담당하는 메서드입니다.
    private fun initView() = with(binding) {
        toolBar.title = getString(R.string.app_name)
        // viewPager의 어댑터를 viewPagerAdapter로 설정합니다.
        viewPager.adapter = viewPagerAdapter

        // TabLayoutMediator를 사용하여 TabLayout과 ViewPager2를 연결합니다.
        // 탭을 생성하고, 각 탭에 대한 제목은 viewPagerAdapter에서 가져옵니다.
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()

        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                // 페이지가 변경되었을 때 호출됨
                if (position == 0) {
                    fabAddTodo.show() // 첫 번째 탭인 경우 FAB 보이기
                } else {
                    fabAddTodo.hide() // 다른 탭인 경우 FAB 숨기기
                }
            }
        })

        // 2주차 선발대 과제 버튼 클릭시 추가하기
        fabAddTodo.setOnClickListener {
            val intent = Intent(this@MainActivity, TodoAddActivity::class.java)
            ResultLauncher.launch(intent)
        }
    }

}