package com.android.jsonplaceholder.di

import JsonPlaceholderRepository
import com.android.jsonplaceholder.repository.JsonPlaceholderApi
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

private val serviceModule = module {
    single {
        JsonPlaceholderApi.getApiService()
    }
}

private val repositoryModule = module {
    single {
        JsonPlaceholderRepository(service = get())
    }
}

private val viewModelModule = module {
    //TODO: Add viewModels
}

fun loadModules() {
    loadKoinModules(
        listOf(
            serviceModule,
            repositoryModule,
            viewModelModule
        )
    )
}