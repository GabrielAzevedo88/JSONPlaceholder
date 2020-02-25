package com.android.jsonplaceholder.holders

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.android.jsonplaceholder.BR
import com.android.jsonplaceholder.model.Comment

class CommentViewHolder(private val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun binding(comment: Comment) {
        binding.apply {
            setVariable(BR.title, comment.getTitle())
            setVariable(BR.body, comment.body)
        }
    }
}
