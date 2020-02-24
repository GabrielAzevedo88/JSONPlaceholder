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

    private fun getVisibility(show: Boolean): Int = takeIf { show }?.run {
        View.VISIBLE
    } ?: View.GONE

    fun setState(state: State) {
        when (state) {
            State.SUCCESS -> {
                contendVisibility.value = getVisibility(true)
                mainLoaderVisibility.value = getVisibility(false)
                deletingLoaderVisibility.value = getVisibility(false)
            }
            State.ERROR -> {
                contendVisibility.value = getVisibility(false)
                mainLoaderVisibility.value = getVisibility(false)
                deletingLoaderVisibility.value = getVisibility(false)
            }
            State.LOADING -> {
                contendVisibility.value = getVisibility(false)
                mainLoaderVisibility.value = getVisibility(true)
                deletingLoaderVisibility.value = getVisibility(false)
            }
            State.DELETING -> {
                contendVisibility.value = getVisibility(false)
                mainLoaderVisibility.value = getVisibility(false)
                deletingLoaderVisibility.value = getVisibility(true)
            }
        }
    }
}