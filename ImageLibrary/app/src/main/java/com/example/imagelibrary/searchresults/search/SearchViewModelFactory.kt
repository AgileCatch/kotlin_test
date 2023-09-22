package com.example.imagelibrary.searchresults.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.imagelibrary.api.RetrofitClient
import com.example.imagelibrary.api.image.ImageModel
import com.example.imagelibrary.api.video.VideoModel
import retrofit2.Response

/**
 * SearchViewModelFactory 클래스는 ViewModelProvider.Factory 인터페이스를 구현하는 사용자 정의 ViewModel 팩토리.
 * 이 팩토리는 SearchViewModel을 생성할 때 필요한 의존성을 주입하는 역할
 */

//Retrofit_interface 타입의 apiService를 매개변수로 받고, apiService는 나중에 SearchViewModel을 생성할 때 주입
class SearchViewModelFactory() : ViewModelProvider.Factory {
    private val repository = Repository()
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(SearchViewModel::class.java)){
            return SearchViewModel(repository) as T
        }
        throw IllegalArgumentException("Not Found ViewModel class.") // 호환되지 않는 경우 알림
    }
}

class Repository {
    private val searchList: MutableList<SearchModel> = mutableListOf()

    private suspend fun searchImage(query: String, sort: String, page: Int): Response<ImageModel> {
        return RetrofitClient.api.imageSearch(query = query, sort = sort, page = page, size = 20)
    }
    private suspend fun searchVideo(query: String, sort: String, page: Int): Response<VideoModel> {
        return RetrofitClient.api.videoSearch(query = query, sort = sort, page = page, size = 20)
    }


    suspend fun searchData(query: String, sort: String, page: Int): MutableList<SearchModel> {
        val imageAPI = searchImage(query, sort, page)
        val videoAPI = searchVideo(query, sort, page)
        searchList.clear()

        if(imageAPI.isSuccessful && videoAPI.isSuccessful){
            imageAPI.body()?.documents?.imageToSearchModel()?.let { searchList.addAll(it) }
            videoAPI.body()?.documents?.videoToSearchModel()?.let { searchList.addAll(it) }

            searchList.sortByDescending { it.dateTime }
        }
        return searchList
    }


    private fun MutableList<ImageModel.Documents>.imageToSearchModel(): MutableList<SearchModel> {
        val list: MutableList<SearchModel> = mutableListOf()
        for (i in 0 until this.size) {
            list.add(
                i,
                SearchModel(
                    title = "[Image] ${this[i].displaySitename}",
                    dateTime = this[i].datetime,
                    url = this[i].imageUrl
                )
            )
        }
        return list
    }

    private fun MutableList<VideoModel.Documents>.videoToSearchModel(): MutableList<SearchModel> {
        val list: MutableList<SearchModel> = mutableListOf()
        for (i in 0 until this.size) {
            list.add(
                i,
                SearchModel(
                    title = "[Video] ${this[i].title}",
                    dateTime = this[i].datetime,
                    url = this[i].thumbnail
                )
            )
        }
        return list
    }
}

/**
 * 제네릭 파라미터 T는 반환될 ViewModel의 타입을 나타냄
 * 함수 내에서는 SearchViewModel의 인스턴스를 생성하고, 필요한 apiService를 주입
 * 이후 생성된 SearchViewModel 인스턴스를 T 타입으로 캐스팅하여 반환
 */

/**
 * 제네릭 파라미터 T는 반환될 ViewModel의 타입을 나타냄
 * 함수 내에서는 SearchViewModel의 인스턴스를 생성하고, 필요한 apiService를 주입
 * 이후 생성된 SearchViewModel 인스턴스를 T 타입으로 캐스팅하여 반환
 */