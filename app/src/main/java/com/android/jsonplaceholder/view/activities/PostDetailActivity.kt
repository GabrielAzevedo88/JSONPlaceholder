package com.android.jsonplaceholder.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.jsonplaceholder.BR
import com.android.jsonplaceholder.R
import com.android.jsonplaceholder.adapters.CommentListAdapter
import com.android.jsonplaceholder.extensions.bindingContentView
import com.android.jsonplaceholder.extensions.observe
import com.android.jsonplaceholder.extensions.swipeRightTransition
import com.android.jsonplaceholder.internal.AppConstant.Companion.EXTRA_POST_ID
import com.android.jsonplaceholder.viewmodel.PostDetailViewModel
import kotlinx.android.synthetic.main.activity_post_detail.*
import kotlinx.android.synthetic.main.content_post_detail_header.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PostDetailActivity : AppCompatActivity() {

    private val viewModel: PostDetailViewModel by viewModel {
        parametersOf(intent.getIntExtra(EXTRA_POST_ID, 0))
    }
    private val commentListAdapter = CommentListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupActionBar()
        setupObservable()
        setupRecycler()
        getData()
    }

    private fun setupBinding() {
        bindingContentView(R.layout.activity_post_detail).run {
            setVariable(BR.viewModel, viewModel)
            lifecycleOwner = this@PostDetailActivity
        }
    }

    private fun setupActionBar() {
        setSupportActionBar(lAppbar_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        lAppbar_toolbar.setNavigationOnClickListener {
            onBackPressed()
            swipeRightTransition()
        }
    }

    private fun setupObservable() {
        viewModel.run {
            observe(comments) {
                it?.run {
                    commentListAdapter.setCommentList(this)
                }
            }
        }
    }

    private fun setupRecycler() {
        aPostDetail_rvComments.apply {
            this.adapter = commentListAdapter
            layoutManager = LinearLayoutManager(this@PostDetailActivity)
        }
    }

    private fun getData() {
        viewModel.getData()
    }
}
