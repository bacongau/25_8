package com.example.a25.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract open class BaseAdapter<T : ViewDataBinding>() : RecyclerView.Adapter<BaseAdapter.BaseViewHolder<*>>() {
    protected abstract fun getLayoutId(): Int

    protected abstract fun solvedOnCreateViewHolder(binding: T): BaseViewHolder<*>
    protected abstract fun solvedOnBindViewHolder(holder:BaseViewHolder<*>, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: T = DataBindingUtil.inflate(layoutInflater, getLayoutId(), parent, false)
        return solvedOnCreateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        solvedOnBindViewHolder(holder, position)
    }

    abstract class BaseViewHolder<U>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        protected abstract fun bind(data: U)
    }

}