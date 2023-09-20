package com.example.imagelibrary.locker

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LockerModel(
    val id: Long,
    val image: Int,
    val name: String,
    val date: String,
    var isBookMark: Boolean = false,
): Parcelable