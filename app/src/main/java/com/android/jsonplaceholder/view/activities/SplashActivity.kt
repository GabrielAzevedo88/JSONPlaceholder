package com.android.jsonplaceholder.view.activities

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.android.jsonplaceholder.R
import com.android.jsonplaceholder.extensions.fadeTransition
import com.android.jsonplaceholder.internal.AppRouter

class SplashActivity : AppCompatActivity() {

    companion object {
        private const val SPLASH_TIME = 3000L
    }

    private val router = AppRouter(this@SplashActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash)
        setupRunning()
    }

    private fun setupRunning() {
        Handler()
            .postDelayed({
                router.goToPostList()
                finish()

                fadeTransition()
            }, SPLASH_TIME)
    }
}
