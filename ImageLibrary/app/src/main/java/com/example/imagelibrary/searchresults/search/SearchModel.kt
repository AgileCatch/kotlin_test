package com.example.imagelibrary.searchresults.search

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchModel (
    val id: Long? = null,
    val image : Int,
    val name :String,
    val date :String,
    var isBookMark : Boolean =false
) : Parcelable