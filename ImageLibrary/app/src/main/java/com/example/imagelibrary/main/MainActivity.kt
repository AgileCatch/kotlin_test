package com.example.imagelibrary.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.imagelibrary.R
import com.example.imagelibrary.databinding.MainActivityBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding

    private val viewPagerAdapter by lazy {
        MainViewPagerAdapter(this@MainActivity)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() = with(binding) {
        //view pager adapter
        viewPager.adapter = viewPagerAdapter



        // TabLayout x ViewPager2
        TabLayoutMediator(tabLayout,viewPager) { tab, position ->
            tab.setText(viewPagerAdapter.getTitle(position))
        }.attach()

        //Tab icon 설정
        //Tab 아이콘 설정
        tabLayout.getTabAt(0)?.setIcon(R.drawable.ic_gallery)
        tabLayout.getTabAt(1)?.setIcon(R.drawable.ic_heart_fill)
    }

}

