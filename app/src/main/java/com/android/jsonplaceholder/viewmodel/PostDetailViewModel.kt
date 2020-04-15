package com.android.jsonplaceholder.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.jsonplaceholder.internal.State
import com.android.jsonplaceholder.model.Comment
import com.android.jsonplaceholder.model.Post
import com.android.jsonplaceholder.model.User
import com.android.jsonplaceholder.repository.JsonPlaceholderRepository
import kotlinx.coroutines.launch

class PostDetailViewModel(val repository: JsonPlaceholderRepository, val postId: Int) :
    BaseViewModel() {
    private val _post: MutableLiveData<Post> = MutableLiveData()
    private val _user: MutableLiveData<User> = MutableLiveData()
    private val _comments: MutableLiveData<List<Comment>> = MutableLiveData()
    private val _noCommentsVisibility = MutableLiveData<Int>().apply {
        value = View.GONE
    }

    val post: LiveData<Post>
        get() = _post
    val user: LiveData<User>
        get() = _user
    val comments: LiveData<List<Comment>>
        get() = _comments
    val noCommentsVisibility: LiveData<Int>
        get() = _noCommentsVisibility

    private fun clearEmptyWarning() {
        _noCommentsVisibility.value = getVisibility(false)
    }

    fun validateComments() {
        _comments.value?.takeIf { it.isEmpty() }?.run {
            _noCommentsVisibility.value = getVisibility(true)
        }
    }

    fun getData() {
        setState(State.LOADING)

        clearEmptyWarning()

        viewModelScope.launch {
            try {

                repository.run {
                    _post.value = getPost(postId)
                    _user.value = getUser(post.value?.userId ?: 0)
                    _comments.value = getPostComments(postId)
                    validateComments()

                    setState(State.SUCCESS)
                }
            } catch (ex: Exception) {
                setState(State.ERROR)
            }
        }
    }
}
