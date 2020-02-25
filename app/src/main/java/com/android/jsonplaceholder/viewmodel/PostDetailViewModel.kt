package com.android.jsonplaceholder.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.jsonplaceholder.internal.State
import com.android.jsonplaceholder.model.Comment
import com.android.jsonplaceholder.model.Post
import com.android.jsonplaceholder.model.User
import com.android.jsonplaceholder.repository.JsonPlaceholderRepository
import kotlinx.coroutines.launch

class PostDetailViewModel(val repository: JsonPlaceholderRepository, val postId: Int) : BaseViewModel() {
    val post: MutableLiveData<Post> = MutableLiveData()
    val user: MutableLiveData<User> = MutableLiveData()
    val comments: MutableLiveData<List<Comment>> = MutableLiveData()

    val noCommentsVisibility = MutableLiveData<Int>().apply {
        value = View.GONE
    }

    private fun clearEmptyWarning() {
        noCommentsVisibility.value = getVisibility(false)
    }

    fun validateComments() {
        comments.value?.takeIf { it.isEmpty() }?.run {
            noCommentsVisibility.value = getVisibility(true)
        }
    }

    fun getData() {
        setState(State.LOADING)

        clearEmptyWarning()

        viewModelScope.launch {
            try {

                repository.run {
                    post.value = getPost(postId)
                    user.value = getUser(post.value?.userId ?: 0)
                    comments.value = getPostComments(postId)
                    validateComments()

                    setState(State.SUCCESS)
                }
            } catch (ex: Exception) {
                setState(State.ERROR)
            }
        }
    }
}
