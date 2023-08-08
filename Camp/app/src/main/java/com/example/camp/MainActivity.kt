package com.example.camp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //툴바 설정
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val pagerAdapter = Adapter(supportFragmentManager)

        val viewPager2=findViewById<ViewPager2>(R.id.viewPager)
        viewPager2.adapter=pagerAdapter

        val tabLayout=findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.setupWithViewPager(viewPager)

    }

}