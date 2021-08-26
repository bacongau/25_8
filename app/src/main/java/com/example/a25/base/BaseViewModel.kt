package com.example.a25.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable


open class BaseViewModel : ViewModel() {

    protected var compositeDisposable = CompositeDisposable()

    protected var isLoading: MutableLiveData<Boolean> = MutableLiveData()

    fun getLoading(): MutableLiveData<Boolean> = isLoading

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}