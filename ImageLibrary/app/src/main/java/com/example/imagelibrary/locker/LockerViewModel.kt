package com.example.imagelibrary.locker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LockerViewModel () : ViewModel() {

    //비즈니스 로직을 전부 viewModel에서 처리 -> 이후 처리한 데이터를 뷰에다 알려줌 {
    // _list : viewModel 내부적으로 control 하는 데이터
    private val _list :MutableLiveData<List<LockerModel>> = MutableLiveData()
    val list : LiveData<List<LockerModel>> get() = _list
    fun addBookmarkModel(lockerModel: LockerModel) {
        val currentList = list.value.orEmpty().toMutableList()
        currentList.add(lockerModel)
        _list.value = currentList
    }

    fun removeBookmarkItem(item: LockerModel, position: Int?) {
        val currentList = list.value.orEmpty().toMutableList()
        val findPosition = position ?: currentList.findIndex(item) // position이 null일 때 findIndex 실행
        if (findPosition == -1) {
            return
        }
        currentList.removeAt(findPosition)
        _list.value = currentList
    }

    fun List<LockerModel>.findIndex(lockerModel: LockerModel): Int {
        // indexOfFirst : 가장 먼저 찾는 값 | 없으면 -1 return
        return indexOfFirst { it.url == lockerModel.url }
    }

    fun loadBookmarkModel(it: List<LockerModel>) {
        _list.value = it
    }


}