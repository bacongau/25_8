package com.example.a25.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.a25.R
import com.example.a25.adapter.PostAdapter
import com.example.a25.base.BaseActivity
import com.example.a25.databinding.ActivityMainBinding
import javax.inject.Inject
import javax.inject.Named

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    private val TAG = "MainActivity"


    private lateinit var postAdapter: PostAdapter

    override fun createViewModel(): MainViewModel {
        return ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        postAdapter = PostAdapter()
        binding.rcvPost.adapter = postAdapter
        viewModel.getListPost()
        viewModel.getLoading().observe(this, {
            if (it == true) {
                loadingDialog.show()
            } else {
                loadingDialog.hide()
            }
        })
        viewModel.getListPostData()
            .observe(this, {
                postAdapter.setList(it)
            })

//        Log.d(TAG, "initView: $str" )
    }

    override fun initData() {

    }

    override fun initListener() {

    }

}