package com.jess.camp.main

import android.app.Activity
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.activity.result.contract.ActivityResultContracts
import com.jess.camp.R
import com.jess.camp.bookmark.BookmarkFragment
import com.jess.camp.todo.TodoAddActivity
import com.jess.camp.todo.TodoFragment
import com.jess.camp.todo.TodoModel

class MainViewPagerAdapter(
    fragmentActivity: FragmentActivity
) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = ArrayList<MainTabs>()

    init {
        fragments.add(
            MainTabs(TodoFragment.newInstance(), R.string.main_tab_todo_title)
        )
        fragments.add(
            MainTabs(BookmarkFragment.newInstance(), R.string.main_tab_bookmark_title),
        )
    }

    private val addTodoLauncher =
        fragmentActivity.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                val newTodoTitle = data?.getStringExtra("newTodoTitle")
                val newTodoContent = data?.getStringExtra("newTodoContent")

                if (!newTodoTitle.isNullOrEmpty() && !newTodoContent.isNullOrEmpty()) {
                    val newTodo = TodoModel(
                        id = fragments[0].fragment.getTodoListAdapterItemCount(),
                        title = newTodoTitle,
                        content = newTodoContent
                    )
                    (fragments[0].fragment as TodoFragment).addTodoItem(newTodo)
                }
            }
        }

    fun getTitle(position: Int): Int {
        return fragments[position].titleRes
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position].fragment
    }

    fun launchAddTodoActivity() {
        val intent = Intent(fragmentActivity, TodoAddActivity::class.java)
        addTodoLauncher.launch(intent)
    }
}

