package com.android.jsonplaceholder.repository

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class JsonPlaceholderApi {
    companion object {

        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        private const val TIMEOUT: Long = 5

        private fun getHttpClient(): OkHttpClient.Builder = OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)

        fun getApiService(): JsonPlaceholderService = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(getHttpClient().build())
            .build()
            .create(JsonPlaceholderService::class.java)
    }
}
