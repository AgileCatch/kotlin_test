package com.example.apple_market1

data class ProductData(
    val productImg: Int,
    var productName: String,
    var introduction: String,
    var seller: String,
    var price: Int,
    var address: String,
    var like: Int,
    var chat: Int,
    //좋아요버튼 추적
    var isliked: Boolean=false
)
