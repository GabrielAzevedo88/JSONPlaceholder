package com.android.jsonplaceholder.model

data class Comment(
    val body: String = "",
    val email: String = "",
    val id: Int = 0,
    val name: String = "",
    val postId: Int = 0
) {

    fun getTitle(): String = "$name (${email.toLowerCase()})"
}
