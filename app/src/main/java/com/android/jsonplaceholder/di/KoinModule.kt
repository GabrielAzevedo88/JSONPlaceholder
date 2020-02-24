package com.android.jsonplaceholder.di

import com.android.jsonplaceholder.adapter.PostListAdapter
import com.android.jsonplaceholder.internal.AppRouter
import com.android.jsonplaceholder.repository.JsonPlaceholderApi
import com.android.jsonplaceholder.repository.JsonPlaceholderRepository
import com.android.jsonplaceholder.viewmodel.PostListViewModel
import org.koin.android.viewmodel.dsl.viewModel
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
    viewModel { PostListViewModel(repository = get()) }
}

private val adapterModule = module {
    factory { (router: AppRouter, action: (Int) -> Unit) ->
        PostListAdapter(
            router = router,
            removeItemAction = action
        )
    }
}

fun loadModules() {
    loadKoinModules(
        listOf(
            serviceModule,
            repositoryModule,
            viewModelModule,
            adapterModule
        )
    )
}
