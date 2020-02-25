package com.android.jsonplaceholder.internal

import android.content.Intent
import androidx.fragment.app.FragmentActivity
import com.android.jsonplaceholder.extensions.swipeLeftTransition
import com.android.jsonplaceholder.internal.AppConstant.Companion.EXTRA_POST_ID
import com.android.jsonplaceholder.view.activities.PostDetailActivity
import com.android.jsonplaceholder.view.activities.PostListActivity

class AppRouter(private val activity: FragmentActivity?) {

    fun goToPostList() {
        activity?.run {
            startActivity(Intent(this, PostListActivity::class.java))
        }
    }

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
