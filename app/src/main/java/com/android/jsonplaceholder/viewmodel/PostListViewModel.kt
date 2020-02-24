package com.android.jsonplaceholder.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.jsonplaceholder.model.Post
import com.android.jsonplaceholder.repository.JsonPlaceholderRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class PostListViewModel (val repository: JsonPlaceholderRepository) : ViewModel() {

    val postList: MutableLiveData<List<Post>> = MutableLiveData()

    fun getData() {
        viewModelScope.launch {
            try {

                postList.value = repository.getPosts()


            }catch (ex: Exception) {
                Log.e("", "")
            }
        }
    }

}
