package com.android.jsonplaceholder.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.jsonplaceholder.internal.State

open class BaseViewModel : ViewModel() {
    val mainLoaderVisibility = MutableLiveData<Int>().apply {
        value = View.VISIBLE
    }
    val deletingLoaderVisibility = MutableLiveData<Int>().apply {
        value = View.GONE
    }
    val contendVisibility = MutableLiveData<Int>().apply {
        value = View.VISIBLE
    }
    val errorVisibility = MutableLiveData<Int>().apply {
        value = View.GONE
    }

    private fun getVisibility(show: Boolean): Int = takeIf { show }?.run {
        View.VISIBLE
    } ?: View.GONE

    fun setState(state: State) {
        contendVisibility.value =
            when (state) {
                State.SUCCESS -> getVisibility(true)
                State.ERROR, State.LOADING, State.DELETING, State.REFRESH_LOADING -> getVisibility(
                    false
                )
            }

        mainLoaderVisibility.value =
            when (state) {
                State.LOADING -> getVisibility(true)
                State.SUCCESS, State.ERROR, State.DELETING, State.REFRESH_LOADING -> getVisibility(
                    false
                )
            }

        deletingLoaderVisibility.value =
            when (state) {
                State.DELETING -> getVisibility(true)
                State.SUCCESS, State.ERROR, State.LOADING, State.REFRESH_LOADING -> getVisibility(
                    false
                )
            }

        errorVisibility.value =
            when (state) {
                State.ERROR -> getVisibility(true)
                State.SUCCESS, State.DELETING, State.LOADING, State.REFRESH_LOADING -> getVisibility(
                    false
                )
            }
    }
}
