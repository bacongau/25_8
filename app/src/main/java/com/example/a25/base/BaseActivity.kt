package com.example.a25.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import com.example.a25.custom.LoadingDialog
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity<VM : BaseViewModel, T : ViewDataBinding> : AppCompatActivity() {

    protected lateinit var viewModel: VM
    protected lateinit var binding: T

    protected abstract fun createViewModel(): VM;

    protected lateinit var loadingDialog: LoadingDialog

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        binding = DataBindingUtil.setContentView(this, getLayoutId())
        viewModel = createViewModel()
        loadingDialog = LoadingDialog(this)
        initView()
        initData()
        initListener()
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun initView()
    protected abstract fun initData()
    protected abstract fun initListener()

}