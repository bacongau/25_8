package com.example.a25.repository

import com.example.a25.api.ApiService
import com.example.a25.model.Post
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class Repository @Inject constructor(var apiService: ApiService) {
    fun getPost(): Single<List<Post>> {
        return apiService.getListPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}