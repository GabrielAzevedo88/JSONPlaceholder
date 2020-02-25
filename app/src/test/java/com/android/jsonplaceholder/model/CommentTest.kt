package com.android.jsonplaceholder.model

import org.junit.Assert
import org.junit.Test

class CommentTest {

    private val commentMock = Comment(
        name = "Xablau History",
        email = "xablau@gmail.com"
    )

    @Test
    fun `when I want the title of the comment then it must return the formatted value`() {
        val nameMock = "Xablau History"
        val emailMock = "xablau@gmail.com"

        Assert.assertEquals("$nameMock ($emailMock)", commentMock.getTitle())
    }
}
