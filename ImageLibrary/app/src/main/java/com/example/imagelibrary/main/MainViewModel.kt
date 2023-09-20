package com.example.imagelibrary.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imagelibrary.locker.LockerModel

class MainViewModel : ViewModel() {
    val searchState : MutableLiveData<SearchState> = MutableLiveData()
    val lockerState : MutableLiveData<LockerState> = MutableLiveData()
}

sealed interface SearchState{
    data class AddBookmark(val bookmarkModel: LockerModel) : SearchState
    data class RemoveBookmark(val bookmarkModel: LockerModel) : SearchState
    data class ModifyBookmark(val bookmarkModel: LockerModel) : SearchState
}

sealed interface LockerState{
    data class ModifyTodo(val lockerModel: LockerModel) : LockerState
}