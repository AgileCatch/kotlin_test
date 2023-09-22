package com.example.imagelibrary.api

import com.example.imagelibrary.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//인터페이스를 사용한다.
object RetrofitClient {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val api : RetrofitInterface by lazy {
        retrofit.create(RetrofitInterface::class.java
        )
    }
}