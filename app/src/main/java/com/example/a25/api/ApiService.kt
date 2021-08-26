package com.example.a25.api

import com.example.a25.model.Post
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    fun getListPosts(): Single<List<Post>>
}