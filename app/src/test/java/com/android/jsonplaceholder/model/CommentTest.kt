package com.android.jsonplaceholder.model

import org.junit.Assert
import org.junit.Test

class CommentTest {

    private val commentMock = Comment(
        name = "Xablau History",
        email = "xablau@gmail.com"
    )

    @Test
    fun `quando desejo o titulo do comentário então deve retornar o valor formatado`() {
        val nameMock = "Xablau History"
        val emailMock = "xablau@gmail.com"

        Assert.assertEquals("$nameMock ($emailMock)", commentMock.getTitle())
    }

}