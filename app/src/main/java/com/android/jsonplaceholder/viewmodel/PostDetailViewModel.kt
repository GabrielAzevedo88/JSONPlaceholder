package com.android.jsonplaceholder.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.jsonplaceholder.internal.State
import com.android.jsonplaceholder.model.Comment
import com.android.jsonplaceholder.model.Post
import com.android.jsonplaceholder.model.User
import com.android.jsonplaceholder.repository.JsonPlaceholderRepository
import kotlinx.coroutines.launch

class PostDetailViewModel(val repository: JsonPlaceholderRepository) : BaseViewModel() {
    val post: MutableLiveData<Post> = MutableLiveData()
    val user: MutableLiveData<User> = MutableLiveData()
    val comments: MutableLiveData<List<Comment>> = MutableLiveData()

    fun getData(postId: Int) {
        setState(State.LOADING)

        viewModelScope.launch {
            try {

                repository.run {
                    post.value = getPost(postId)
                    user.value = getUser(post.value?.userId ?: 0)
                    comments.value = getPostComments(postId)

                    setState(State.SUCCESS)
                }
            } catch (ex: Exception) {
                setState(State.ERROR)
            }
        }
    }
}
