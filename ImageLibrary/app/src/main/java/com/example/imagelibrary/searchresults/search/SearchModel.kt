package com.example.imagelibrary.searchresults.search

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class SearchModel(
    var title: String,
    var dateTime: String,
    var url: String,
    var isLike : Boolean= false
) : Parcelable

