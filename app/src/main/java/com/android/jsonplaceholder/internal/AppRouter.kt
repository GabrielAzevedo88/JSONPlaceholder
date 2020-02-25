package com.android.jsonplaceholder.internal

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.android.jsonplaceholder.extensions.swipeLeftTransition
import com.android.jsonplaceholder.internal.AppConstant.Companion.EXTRA_POST_ID
import com.android.jsonplaceholder.view.activities.PostDetailActivity

class AppRouter(private val activity: FragmentActivity?) {

    fun goToPostDetail(postId: Int) {
        activity?.run {
            Intent(this, PostDetailActivity::class.java).apply {
                putExtra(EXTRA_POST_ID, postId)

                startActivity(this)

                swipeLeftTransition()
            }
        }
    }
}
