package com.android.jsonplaceholder.repository

import com.android.jsonplaceholder.model.Album
import com.android.jsonplaceholder.model.Comment
import com.android.jsonplaceholder.model.Photo
import com.android.jsonplaceholder.model.Post
import com.android.jsonplaceholder.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceholderService {

    @GET("posts")
    suspend fun getPosts(): Response<List<Post>>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") id: Int): Response<Post>

    @GET("users")
    suspend fun getUsers(): Response<List<User>>

    @GET("posts/{postId}/comments")
    suspend fun getPostComments(@Path("postId") postId: Int): Response<List<Comment>>

    @GET("users/{userId}/albums")
    suspend fun getUserAlbums(@Path("userId") userId: Int): Response<List<Album>>

    @GET("albums/{albumId}/photos")
    suspend fun getPhotos(@Path("albumId") albumId: Int): Response<List<Photo>>

}