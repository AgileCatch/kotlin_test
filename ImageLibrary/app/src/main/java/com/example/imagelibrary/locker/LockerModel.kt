package com.example.imagelibrary.locker

data class LockerModel (
    val id: Int,
    val image : Int,
    val name :String,
    val date :String,
    var isBookMark : Boolean =false
)