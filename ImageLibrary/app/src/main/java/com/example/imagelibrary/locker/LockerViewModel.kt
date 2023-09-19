package com.example.imagelibrary.locker

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LockerViewModel () : ViewModel() {

    //비즈니스 로직을 전부 viewModel에서 처리 -> 이후 처리한 데이터를 뷰에다 알려줌 {
    // _list : viewModel 내부적으로 control 하는 데이터
    private val _list :MutableLiveData<List<LockerModel>> = MutableLiveData()
    val list : LiveData<List<LockerModel>> get() = _list

    init {
        _list.value= arrayListOf<LockerModel>().apply {
            for (i in 0 until 3){
                val iString = "${i}"
                val iLong = iString.toLong()
                add(
                    LockerModel(
                        iLong,
                        0,
                        "Name ${i}",
                        "Date ${i}",
                    )
                )
            }
        }
    }
    fun findIndex(lockerModel: LockerModel): Int? {
        val currentList = list.value?.toMutableList()
        val findTodoById = currentList?.find { // 수정하고자 하는 Model의 id와 currentList의 id를 비교해 같은 id 를 찾음
            it.id == lockerModel.id
        }
        return currentList?.indexOf(findTodoById)//indexOf : 찾고자 하는 Array의 index를 반환
    }


}