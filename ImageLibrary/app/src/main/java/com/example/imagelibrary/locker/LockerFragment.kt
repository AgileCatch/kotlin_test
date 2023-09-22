package com.example.imagelibrary.locker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.imagelibrary.EntryType
import com.example.imagelibrary.databinding.LockerFragmentBinding
import com.example.imagelibrary.main.LockerState
import com.example.imagelibrary.main.MainViewModel
import com.example.imagelibrary.utils.saveBookmarkData

class LockerFragment : Fragment() {
    companion object {
        //static 함수로 검색결과 fragment를 가져올 수 있는 instance 생성
        //이걸통해서 프래그먼트를 만듬
        fun newInstance() = LockerFragment()
        val PREFERENCES_KEY = "preference_key_name"
    }

    private var _binding: LockerFragmentBinding? = null
    private val binding get() = _binding!!

    private val listAdapter by lazy {
        LockerListAdapter(
            onLikeChecked = { item, position ->
                removeBookmarkItem(item, position)
                modifyToSearchTab(item, EntryType.EDIT.name)
            }
        )
    }
    private val viewModel: LockerViewModel by viewModels { LockerViewModelFactory() }
    private val activityViewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = LockerFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    //프래그먼트 뷰 생성후 해야할일 설정하는곳
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //recyclerView 에 대한 초기화를 해줘야함
        initView()
        initViewModel()

    }

    private fun initView() = with(binding) {
        //어댑터 연결
        lockerList.adapter = listAdapter
    }

    private fun initViewModel() = with(viewModel) {
        // viewModel 상 읽기용 list
        viewModel.list.observe(viewLifecycleOwner, Observer {
            listAdapter.submitList(it)
            context?.let { context ->
                saveBookmarkData(
                    context,
                    PREFERENCES_KEY,
                    it
                )
            } // SharedPreference 데이터 저장
        })
        activityViewModel.bookmarkState.observe(viewLifecycleOwner, Observer { state ->
            when (state) {
                is LockerState.AddBookmark -> addBookmarkItem(state.bookmarkModel)
                is LockerState.RemoveBookmark -> removeBookmarkItem(state.bookmarkModel, null)
            }
        })
    }

    private fun addBookmarkItem(bookmarkModel: LockerModel) {
        viewModel.addBookmarkModel(bookmarkModel)
    }

    private fun removeBookmarkItem(bookmarkModel: LockerModel, position: Int?) {
        viewModel.removeBookmarkItem(bookmarkModel, position)
    }

    private fun modifyToSearchTab(item: LockerModel, name: String) {
        activityViewModel.updateSearchState(item, name)
    }


    //프래그먼트의 메모리 누수를 방지하기 위해 넣어줌 (구글 권장)
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}