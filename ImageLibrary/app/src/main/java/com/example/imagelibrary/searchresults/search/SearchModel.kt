package com.example.imagelibrary.searchresults.search

import android.os.Parcelable
import com.example.imagelibrary.locker.LockerModel
import kotlinx.parcelize.Parcelize
@Parcelize
data class SearchModel(
    val title: String,
    val dateTime: String,
    val url: String,
    val isLiked: Boolean = false
) : Parcelable
fun SearchModel.toLockerModel(): LockerModel {
    return LockerModel(
        title = title,
        dateTime = dateTime,
        url = url,
        isLiked = isLiked
    )
}

