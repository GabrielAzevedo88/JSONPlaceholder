package com.android.jsonplaceholder.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.jsonplaceholder.BR
import com.android.jsonplaceholder.R
import com.android.jsonplaceholder.adapter.PostListAdapter
import com.android.jsonplaceholder.extensions.bindingContentView
import com.android.jsonplaceholder.extensions.observe
import com.android.jsonplaceholder.internal.AppRouter
import com.android.jsonplaceholder.viewmodel.PostListViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PostListActivity : AppCompatActivity() {

    private val viewModel: PostListViewModel by viewModel()
    private val listAdapter: PostListAdapter by inject {
        parametersOf(
            AppRouter(this@PostListActivity)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBinding()
        setupObservable()
        setupRecycler()
        getData()
    }

    private fun setupBinding() {
        bindingContentView(R.layout.activity_main).run {
            setVariable(BR.viewModel, viewModel)
        }
    }

    private fun setupObservable() {
        viewModel.run {
            observe(postList) {
                it?.let {
                    listAdapter.setPosts(it)
                }
            }
        }
    }

    private fun setupRecycler() {
        aPostList_rvPostList.apply {
            this.adapter = listAdapter
            layoutManager = LinearLayoutManager(this@PostListActivity)
        }
    }

    private fun getData() {
        viewModel.getData()
    }

}
