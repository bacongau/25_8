package com.example.a25.adapter

import com.example.a25.R
import com.example.a25.base.BaseAdapter
import com.example.a25.databinding.ItemPostBinding
import com.example.a25.model.Post

class PostAdapter : BaseAdapter<ItemPostBinding>() {

    private var post: List<Post>? = listOf()

    fun setList(post: List<Post>) {
        this.post = post
        notifyDataSetChanged()
    }



    override fun getLayoutId(): Int {
        return R.layout.item_post
    }

    override fun solvedOnCreateViewHolder(binding: ItemPostBinding): BaseViewHolder<Post> {
        return PostViewHolder(binding)
    }

    override fun solvedOnBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        (holder as PostViewHolder).bind(post!!.get(position))
    }

    override fun getItemCount(): Int {
        return post!!.size
    }

    private class PostViewHolder(var binding: ItemPostBinding) :
        BaseViewHolder<Post>(binding.root) {

        public override fun bind(data: Post) {
            binding.post = data
        }

    }
}