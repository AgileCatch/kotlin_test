package com.example.imagelibrary.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imagelibrary.EntryType
import com.example.imagelibrary.locker.LockerModel
import com.example.imagelibrary.locker.toSearchModel
import com.example.imagelibrary.searchresults.search.SearchModel
import com.example.imagelibrary.searchresults.search.toLockerModel

class MainViewModel : ViewModel() {
    private val _searchState: MutableLiveData<SearchState> = MutableLiveData()
    private val _bookmarkState: MutableLiveData<LockerState> = MutableLiveData()

    val bookmarkState: LiveData<LockerState> get() = _bookmarkState
    val searchState: LiveData<SearchState> get() = _searchState

    fun updateBookmarkState(item: SearchModel, entryType: String) {
        when (entryType) {
            EntryType.ADD.name -> _bookmarkState.value =
                LockerState.AddBookmark(item.toLockerModel())

            EntryType.REMOVE.name -> _bookmarkState.value =
                LockerState.RemoveBookmark(item.toLockerModel())
        }
    }

    fun updateSearchState(item: LockerModel, entryType: String) {
        when (entryType) {
            EntryType.ADD.name -> Unit
            EntryType.REMOVE.name -> Unit
            EntryType.EDIT.name -> _searchState.value = SearchState.ModifySearch(item.toSearchModel())
        }
    }
}

sealed interface SearchState{
    data class ModifySearch(val searchModel: SearchModel) : SearchState
}

sealed interface LockerState{
    data class AddBookmark(val bookmarkModel: LockerModel) : LockerState
    data class RemoveBookmark(val bookmarkModel: LockerModel) : LockerState
}