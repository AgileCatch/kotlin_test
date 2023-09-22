package com.example.imagelibrary.searchresults.search


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class SearchViewModel(
    private val repository: Repository
) : ViewModel() {
    private val _list : MutableLiveData<List<SearchModel>> = MutableLiveData()
    val list : LiveData<List<SearchModel>> get()= _list


    //이미지 검색
    fun searchItems(query: String){
        viewModelScope.launch {
            val searchData = repository.searchData(query,"recency", 1)
            _list.value = searchData.toMutableList()
        }
    }
    // 일치하는 데이터 찾기
    private fun findIndex(searchModel: SearchModel) : Int?{
        val currentList = list.value?.toMutableList()
        val findByURL = currentList?.find {
            it.url == searchModel.url
        }
        return currentList?.indexOf(findByURL)
    }

    // 리스트 수정
    fun modifyList(item: SearchModel, position: Int?) {
        val currentList = list.value?.toMutableList()
        val findPosition = position ?: findIndex(item)
        if (findPosition != null && findPosition != -1) // 현재 List에 BookmarkItem이 없을 때 예외처리
        {
            currentList?.set(findPosition, item)
        }
        _list.value = currentList!!
    }


}