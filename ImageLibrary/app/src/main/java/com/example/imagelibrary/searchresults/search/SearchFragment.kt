package com.example.imagelibrary.searchresults.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.imagelibrary.databinding.SearchFragmentBinding

class SearchFragment : Fragment() {
    companion object {
        //static 함수로 검색결과 fragment를 가져올 수 있는 instance 생성
        //이걸통해서 프래그먼트를 만듬
        fun newInstance() = SearchFragment()
    }

    private var _binding: SearchFragmentBinding? = null
    private val binding get() = _binding!!

    private val listAdapter by lazy {
        SearchListAdapter()
    }

    //현업코드 by viewModels -> 의존성 추가해주어야함.'
//    val apiServiceInstance = RetrofitClient.apiService
    private val viewModel: SearchViewModel by viewModels { SearchViewModelFactory() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = SearchFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    //프래그먼트 뷰 생성후 해야할일 설정하는곳
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModel()

    }

    private fun initViewModel() = with(viewModel) {
        // viewModel 상 읽기용 list
        list.observe(viewLifecycleOwner) { // Fragment LV : observe(viewLifecycleOwner)
            listAdapter.submitList(it)
        }
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


    //프래그먼트의 메모리 누수를 방지하기 위해 넣어줌 (구글 권장)
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}


