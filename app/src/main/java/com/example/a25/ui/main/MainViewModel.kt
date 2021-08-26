package com.example.a25.ui.main

import androidx.lifecycle.MutableLiveData
import com.example.a25.base.BaseViewModel
import com.example.a25.model.Post
import com.example.a25.repository.Repository
import javax.inject.Inject

class MainViewModel @Inject constructor(var repository: Repository) : BaseViewModel() {

    private var listPost: MutableLiveData<List<Post>> = MutableLiveData()

    fun getListPost() {
        compositeDisposable.add(repository.getPost()
            .doOnSubscribe {
                isLoading.value = true
            }
            .doFinally {
                isLoading.value = false
            }
            .subscribe(
                {
                    listPost.value = it
                }, {

                }
            ))
    }

    fun getListPostData(): MutableLiveData<List<Post>> = listPost
}