package com.example.imagelibrary.api


import com.example.imagelibrary.Constants
import com.example.imagelibrary.api.image.ImageModel
import com.example.imagelibrary.api.video.VideoModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface RetrofitInterface {
    //사용할 쿼리 지정 사이트에 나와있는대로 작성 해야함
    //suspend : 메인쓰레드(본업) 에서 오래걸리는 작업을 하면 안됨 그렇기때문에 suspend라는 개념(부업) 을 사용
    //오래걸리는거니 메인쓰레드에서 사용하면안됨
    @GET("v2/search/image")
    suspend fun imageSearch(
        @Header("Authorization") apiKey: String = Constants.AUTH_HEADER,
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): Response<ImageModel>//반환

    @GET("v2/search/vclip")
    suspend fun videoSearch(
        @Header("Authorization") apiKey: String = Constants.AUTH_HEADER,
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): Response<VideoModel>//반환

}
