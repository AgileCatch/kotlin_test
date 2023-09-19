package com.example.imagelibrary.locker

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LockerViewModelFactory : ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(LockerViewModel::class.java)){
            return LockerViewModel() as T
        }
        throw IllegalArgumentException("Not Found ViewModel class.")
    }
}