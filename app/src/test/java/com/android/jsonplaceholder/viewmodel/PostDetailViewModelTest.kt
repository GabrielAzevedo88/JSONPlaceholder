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
class PostDetailViewModelTest {
    private val repository: JsonPlaceholderRepository = mockk(relaxed = true)
    private lateinit var sut: PostDetailViewModel

    @Before
    fun setup() {
        sut = PostDetailViewModel(repository, 0)
    }

    @Test
    fun `when there is no comment then I must show a message`() {
        sut.run {
            comments.value = emptyList()
            validateComments()

            Assert.assertEquals(View.VISIBLE, noCommentsVisibility.value)
        }
    }
}
