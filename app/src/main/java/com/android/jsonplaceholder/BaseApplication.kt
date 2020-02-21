package com.android.jsonplaceholder

import android.app.Application
import com.android.jsonplaceholder.di.loadModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    fun setupKoin() {
        startKoin {
            androidContext(this@BaseApplication)
            androidLogger()
            loadModules()
        }
    }
}