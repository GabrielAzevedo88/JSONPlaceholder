package com.android.jsonplaceholder.repository

import com.android.jsonplaceholder.post.model.Album
import com.android.jsonplaceholder.post.model.Comment
import com.android.jsonplaceholder.post.model.Photo
import com.android.jsonplaceholder.post.model.Post
import com.android.jsonplaceholder.user.model.User

interface JsonPlaceholderDataContract {

    suspend fun getPosts(): List<Post>

    suspend fun getPost(id: Int): Post

    suspend fun getUsers(): List<User>

    suspend fun getPostComments(postId: Int): List<Comment>

    suspend fun getUserAlbums(userId: Int): List<Album>

    suspend fun getPhotos(albumId: Int): List<Photo>

}