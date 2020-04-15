package com.android.jsonplaceholder.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.jsonplaceholder.internal.State

open class BaseViewModel : ViewModel() {
    private val _mainLoaderVisibility = MutableLiveData<Int>().apply {
        value = View.VISIBLE
    }
    private val _deletingLoaderVisibility = MutableLiveData<Int>().apply {
        value = View.GONE
    }
    private val _contendVisibility = MutableLiveData<Int>().apply {
        value = View.VISIBLE
    }
    private val _errorVisibility = MutableLiveData<Int>().apply {
        value = View.GONE
    }

    val mainLoaderVisibility: LiveData<Int>
        get() = _mainLoaderVisibility
    val deletingLoaderVisibility: LiveData<Int>
        get() = _deletingLoaderVisibility
    val contendVisibility: LiveData<Int>
        get() = _contendVisibility
    val errorVisibility: LiveData<Int>
        get() = _errorVisibility

    fun getVisibility(show: Boolean): Int = takeIf { show }?.run {
        View.VISIBLE
    } ?: View.GONE

    fun setState(state: State) {
        _contendVisibility.value =
            when (state) {
                State.SUCCESS -> getVisibility(true)
                State.ERROR, State.LOADING, State.DELETING, State.REFRESH_LOADING -> getVisibility(
                    false
                )
            }

        _mainLoaderVisibility.value =
            when (state) {
                State.LOADING -> getVisibility(true)
                State.SUCCESS, State.ERROR, State.DELETING, State.REFRESH_LOADING -> getVisibility(
                    false
                )
            }

        _deletingLoaderVisibility.value =
            when (state) {
                State.DELETING -> getVisibility(true)
                State.SUCCESS, State.ERROR, State.LOADING, State.REFRESH_LOADING -> getVisibility(
                    false
                )
            }

        _errorVisibility.value =
            when (state) {
                State.ERROR -> getVisibility(true)
                State.SUCCESS, State.DELETING, State.LOADING, State.REFRESH_LOADING -> getVisibility(
                    false
                )
            }
    }
}
