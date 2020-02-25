package com.android.jsonplaceholder.model

data class Comment(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
) {

    fun getTitle(): String = "$name (${email.toLowerCase()})"
}
