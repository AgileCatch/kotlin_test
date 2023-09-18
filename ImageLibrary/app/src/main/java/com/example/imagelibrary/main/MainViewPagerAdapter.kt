package com.example.imagelibrary.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.imagelibrary.R
import com.example.imagelibrary.locker.LockerFragment
import com.example.imagelibrary.searchResults.SearchFragment

class MainViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = ArrayList<MainTabs>()

    init {
        fragments.add(
            MainTabs(SearchFragment.newInstance(), R.string.main_tab_search_title)
        )
        fragments.add(
            MainTabs(LockerFragment.newInstance(), R.string.main_tab_locker_title),
        )
    }

//    fun getFragment(position: Int): Fragment {
//        return fragments[position].fragment
//    }

    fun getTitle(position: Int): Int {
        return fragments[position].titleRes
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position].fragment
    }
}