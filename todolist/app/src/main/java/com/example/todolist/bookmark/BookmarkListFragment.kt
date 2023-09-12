package com.example.todolist.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todolist.databinding.BookmarkListFragmentBinding

class BookmarkListFragment : Fragment() {
    //static 함수를 사용하여 bookmark Fragment를 가져올 수 있는 instance를 만들어줌
    companion object {
        fun newInstance() = BookmarkListFragment()
    }


    private var _binding: BookmarkListFragmentBinding? = null
    private val binding get() = _binding!!

    //리사이클러뷰어댑터 연결
    private val recyclerViewAdapter by lazy {
        BookMarkListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        //바인딩을 넣어줘야함
        _binding = BookmarkListFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()

        // for testww
        val testList = arrayListOf<BookMarkModel>()
        for (i in 0 until 100) {
            testList.add(
                BookMarkModel(
                    id = i,
                    "Bookmark Title $i"
                )
            )
        }

        recyclerViewAdapter.addItems(testList)
    }

    private fun initView() {
        binding.bookmarkList.adapter = recyclerViewAdapter

    }

    //바인딩을 위해 메모리 누수를 위해 강제적으로 초기화시켜줘야함
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}