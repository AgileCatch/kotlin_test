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
    val list : LiveData<List<SearchModel>> get() = _list


    fun searchItems(query: String){
        viewModelScope.launch {
            val searchData = repository.searchData(query,"recency", 1)
            _list.value = searchData.toMutableList()
        }
    }



}