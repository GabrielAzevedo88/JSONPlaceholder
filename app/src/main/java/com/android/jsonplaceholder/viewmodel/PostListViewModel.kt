package com.android.jsonplaceholder.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.jsonplaceholder.internal.AppConstant.Companion.TAG_ERROR
import com.android.jsonplaceholder.internal.State
import com.android.jsonplaceholder.model.Post
import com.android.jsonplaceholder.repository.JsonPlaceholderRepository
import kotlinx.coroutines.launch

class PostListViewModel(val repository: JsonPlaceholderRepository) : BaseViewModel() {

    private val _postList: MutableLiveData<List<Post>> = MutableLiveData()
    private val _successDeletedId: MutableLiveData<Int> = MutableLiveData()
    private val _noPostFoundVisibility = MutableLiveData<Int>().apply {
        value = View.GONE
    }

    val postList: LiveData<List<Post>>
        get() = _postList

    val successDeletedId: LiveData<Int>
        get() = _successDeletedId

    val noPostFoundVisibility: LiveData<Int>
        get() = _noPostFoundVisibility

    private fun clearEmptyWarning() {
        _noPostFoundVisibility.value = getVisibility(false)
    }

    fun validateData() {
        postList.value?.takeIf { it.isEmpty() }?.run {
            _noPostFoundVisibility.value = getVisibility(true)
        }
    }

    fun getData(isRefresh: Boolean = false) {
        clearEmptyWarning()

        takeIf { isRefresh }?.run {
            setState(State.REFRESH_LOADING)
        } ?: setState(State.LOADING)

        viewModelScope.launch {
            try {
                _postList.value = repository.getPosts()
                validateData()

                setState(State.SUCCESS)
            } catch (ex: Exception) {
                Log.e(TAG_ERROR, ex.message.orEmpty())
                setState(State.ERROR)
            }
        }
    }

    /** ATTENTION: Fake method. Always returns 520 **/
    fun deletePost(id: Int) {
        setState(State.DELETING)
        viewModelScope.launch {
            try {
                repository.deletePost(id)
            } catch (ex: Exception) {
                Log.e(TAG_ERROR, ex.message.orEmpty())
            } finally {
                _successDeletedId.value = id
                setState(State.SUCCESS)
            }
        }
    }
}
