package com.android.jsonplaceholder.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.android.jsonplaceholder.R
import com.android.jsonplaceholder.holders.CommentViewHolder
import com.android.jsonplaceholder.model.Comment

class CommentListAdapter :
    RecyclerView.Adapter<CommentViewHolder>() {

    private var commentList: List<Comment> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder =
        CommentViewHolder(
            DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context),
                R.layout.layout_post_comment_item,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) =
        holder.binding(commentList[position])

    override fun getItemCount(): Int = commentList.count()

    fun setCommentList(list: List<Comment>) {
        this.commentList = list
        notifyDataSetChanged()
    }
}
