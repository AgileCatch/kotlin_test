package com.example.imagelibrary.searchresults.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.concurrent.atomic.AtomicLong

class SearchViewModel (private val idGenerate: AtomicLong) : ViewModel() {

    //비즈니스 로직을 전부 viewModel에서 처리 -> 이후 처리한 데이터를 뷰에다 알려줌 {
    // _list : viewModel 내부적으로 control 하는 데이터
    private val _list :MutableLiveData<List<SearchModel>> = MutableLiveData()

    // viewmodel 내부에서 사용하는 읽기만 가능한 상태
    val list : LiveData<List<SearchModel>> get() = _list

    //AtomicLong을 통해 id값 부여
    init {
        _list.value= arrayListOf<SearchModel>().apply {
            for (i in 0 until 3){
                add(
                    SearchModel(
                        this@SearchViewModel.idGenerate.getAndIncrement(),
                        0,
                        "Name ${i}",
                        "Date ${i}",
                    )
                )
            }
        }
    }

    fun addTodoItem(searchModel: SearchModel?) {
        if (searchModel == null) {
            return
        }
        val currentList = list.value.orEmpty().toMutableList()
        _list.value = currentList.apply {
            add(
                searchModel.copy( // item이 추가 될 때 id를 생성해서 반영해줌
                    id = idGenerate.getAndIncrement()
                )
            )
        }
    }
}