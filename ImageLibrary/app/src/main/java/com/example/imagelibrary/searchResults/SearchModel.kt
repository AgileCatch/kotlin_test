package com.example.imagelibrary.searchResults

data class SearchModel (
    val id: Int,
    val image : Int,
    val name :String,
    val date :String,
    var isBookMark : Boolean =false
)