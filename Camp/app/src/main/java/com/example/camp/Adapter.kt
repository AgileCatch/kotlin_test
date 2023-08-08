package com.example.camp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter

class Adapter(fm : FragmentManager) : FragmentStateAdapter(Fragment()) {

    fun getItem(position: Int): Fragment {
        val fragment =  when(position)
        {
            0->TodoFragment().newInstant()
            1-> BookMarkFragment().newInstant()
            else -> TodoFragment().newInstant()
        }
        return fragment
    }

    //tab의 개수만큼 return
    override fun getCount(): Int = 2

    //tab의 이름 fragment마다 바꾸게 하기
    override fun getPageTitle(position: Int): CharSequence? {
        val title = when(position)
        {
            0->"0ne"
            1->"Two"
            2->"Three"
            else -> "main"
        }
        return title     }
    }
}