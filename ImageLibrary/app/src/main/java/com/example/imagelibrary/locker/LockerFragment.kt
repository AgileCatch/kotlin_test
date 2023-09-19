package com.example.imagelibrary.locker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.imagelibrary.R
import com.example.imagelibrary.databinding.LockerFragmentBinding

class LockerFragment : Fragment() {
    companion object {
        //static 함수로 검색결과 fragment를 가져올 수 있는 instance 생성
        //이걸통해서 프래그먼트를 만듬
        fun newInstance() = LockerFragment()
    }

    private var _binding: LockerFragmentBinding? = null
    private val binding get() = _binding!!

    private val listAdapter by lazy {
        LockerListAdapter()
    }


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

        // for test
        val testList = arrayListOf<LockerModel>()
        for (i in 0 until 100) {
            testList.add(
                LockerModel(
                    id = i,
                    0,
                    "Locker Name $i",
                    "Locker Date $i"
                )
            )
        }
        listAdapter.addItems(testList)
    }

    private fun initView() = with(binding) {
        //어댑터 연결
        lockerList.adapter =listAdapter
    }


    //프래그먼트의 메모리 누수를 방지하기 위해 넣어줌 (구글 권장)
    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}