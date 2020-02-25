package com.android.jsonplaceholder.repository

import com.android.jsonplaceholder.model.Album
import com.android.jsonplaceholder.model.Comment
import com.android.jsonplaceholder.model.Photo
import com.android.jsonplaceholder.model.Post
import com.android.jsonplaceholder.model.User

interface JsonPlaceholderDataContract {

    suspend fun getPosts(): List<Post>

    suspend fun getPost(id: Int): Post

    suspend fun getUser(id: Int): User

    suspend fun getPostComments(postId: Int): List<Comment>

    suspend fun getUserAlbums(userId: Int): List<Album>

    suspend fun getPhotos(albumId: Int): List<Photo>

    suspend fun deletePost(id: Int): Boolean
}
