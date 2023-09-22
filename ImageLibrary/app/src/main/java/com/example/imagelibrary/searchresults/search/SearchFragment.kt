package com.example.imagelibrary.searchresults.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.imagelibrary.EntryType
import com.example.imagelibrary.databinding.SearchFragmentBinding
import com.example.imagelibrary.main.MainViewModel
import com.example.imagelibrary.main.SearchState

class SearchFragment : Fragment() {
    companion object {
        //static 함수로 검색결과 fragment를 가져올 수 있는 instance 생성
        //이걸통해서 프래그먼트를 만듬
        fun newInstance() = SearchFragment()
    }

    private var _binding: SearchFragmentBinding? = null
    private val binding get() = _binding!!
    private val listAdapter by lazy {
        SearchListAdapter(
            onLikeChecked = { item, position ->
                modifySearchItem(item, position)
                if (item.isLiked) {
                    addToBookmarkTab(item, EntryType.ADD.name)
                } else {
                    removeToBookmarkTab(item, EntryType.REMOVE.name)
                }
            }
        )
    }

    private val viewModel: SearchViewModel by viewModels { SearchViewModelFactory() }
    private val activityViewModel: MainViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = SearchFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()
    }

    private fun initViewModel() = with(viewModel) {
        list.observe(viewLifecycleOwner, Observer {
            listAdapter.submitList(it)
        })
        activityViewModel.searchState.observe(viewLifecycleOwner, Observer { state ->
            when(state){
                is SearchState.ModifySearch -> modifySearchItem(state.searchModel, null)
            }
        })
    }

    private fun initView() = with(binding) {
        searchList.adapter = listAdapter

        //검색
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { viewModel.searchItems(it) }
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }
        })

    }

    private fun modifySearchItem(item: SearchModel, position: Int?) {
        viewModel.modifyList(item, position)
    }
    private fun removeToBookmarkTab(item: SearchModel, name: String) {
        activityViewModel.updateBookmarkState(item,name)
    }

    private fun addToBookmarkTab(item: SearchModel, name: String) {
        activityViewModel.updateBookmarkState(item,name)
    }


    //프래그먼트의 메모리 누수를 방지하기 위해 넣어줌 (구글 권장)
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}


