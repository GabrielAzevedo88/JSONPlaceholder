package com.android.jsonplaceholder.extensions

import androidx.fragment.app.FragmentActivity
import com.android.jsonplaceholder.R

fun FragmentActivity.swipeLeftTransition() {
    this.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
}

fun FragmentActivity.swipeRightTransition() {
    this.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
}

fun FragmentActivity.fadeTransition() {
    this.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
}
