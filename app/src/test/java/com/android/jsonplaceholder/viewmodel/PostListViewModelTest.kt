package com.android.jsonplaceholder.viewmodel

import android.view.View
import com.android.jsonplaceholder.repository.JsonPlaceholderRepository
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PostListViewModelTest {

    private val repository: JsonPlaceholderRepository = mockk(relaxed = true)
    private lateinit var sut: PostListViewModel

    @Before
    fun setup() {
        sut = PostListViewModel(repository)
    }

    @Test
    fun `when there is no post then I must show a message`() {
        sut.run {
            postList.value = emptyList()
            validateData()

            Assert.assertEquals(View.VISIBLE, noPostFoundVisibility.value)
        }
    }
}
