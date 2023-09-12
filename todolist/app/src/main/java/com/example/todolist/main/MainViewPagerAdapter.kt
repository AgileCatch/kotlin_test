package com.example.todolist.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.todolist.bookmark.BookmarkListFragment
import com.example.todolist.todo.TodoListFragment

class MainViewPagerAdapter(private val activity: FragmentActivity) :
    FragmentStateAdapter(activity) {
    private val fragments = ArrayList<MainTabs>()

    init {
        fragments.add(
            MainTabs(TodoListFragment.newInstance(), "Todo")
        )
        fragments.add(
            MainTabs(BookmarkListFragment.newInstance(), "BookMark")
        )
    }

    fun getTitle(position: Int):String{
        return fragments[position].title
    }

    //화면의 갯수
    override fun getItemCount(): Int {
        return fragments.size
    }

    //프래그먼트를 정의해 화면에 꼿아주는것
    override fun createFragment(position: Int): Fragment {
        return fragments[position].fragment
    }


}