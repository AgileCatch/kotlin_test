package com.example.apple_market1

import java.text.NumberFormat
import java.util.Locale

fun formatPrice(price: Int): String { // 천 단위로 콤마(,) 찍어 표시
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault())
    return formatter.format(price)
}