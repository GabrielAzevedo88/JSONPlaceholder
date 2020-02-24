package com.android.jsonplaceholder.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.android.jsonplaceholder.R
import com.android.jsonplaceholder.internal.AppRouter
import com.android.jsonplaceholder.model.Post

class PostListAdapter(val router: AppRouter) : RecyclerView.Adapter<PostListViewHolder>() {

    private var postList: List<Post> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListViewHolder =
        PostListViewHolder(
            DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context),
                R.layout.layout_post_list_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: PostListViewHolder, position: Int) {
        val post = postList[position]

        holder.binding(post)
    }

    override fun getItemCount(): Int = postList.count()

    fun setPosts(posts: List<Post>) {
        this.postList = posts
        notifyDataSetChanged()
    }

}