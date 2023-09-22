package com.example.imagelibrary.locker

import android.os.Parcelable
import com.example.imagelibrary.searchresults.search.SearchModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LockerModel(
    val title : String,
    val dateTime : String,
    val url : String,
    val isLiked : Boolean
) : Parcelable
fun LockerModel.toSearchModel(): SearchModel {
    return SearchModel(
        title = title,
        dateTime = dateTime,
        url = url,
        isLiked = isLiked
    )
}