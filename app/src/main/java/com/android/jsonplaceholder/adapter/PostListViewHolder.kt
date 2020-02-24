package com.android.jsonplaceholder.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.android.jsonplaceholder.BR
import com.android.jsonplaceholder.model.Post

class PostListViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun binding(post: Post){

        binding.apply {
            setVariable(BR.post, post)
        }

    }

}
