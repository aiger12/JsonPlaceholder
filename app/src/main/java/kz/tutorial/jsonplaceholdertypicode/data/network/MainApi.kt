package kz.tutorial.jsonplaceholdertypicode.data.network

import kz.tutorial.jsonplaceholdertypicode.data.entity.AlbumRemote
import kz.tutorial.jsonplaceholdertypicode.data.entity.PhotoRemote
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Album
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Post
import kz.tutorial.jsonplaceholdertypicode.domain.entity.User
import kz.tutorial.jsonplaceholdertypicode.domain.repository.PhotoRepository
import kz.tutorial.jsonplaceholdertypicode.domain.request.LoginRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MainApi {

    @GET("posts")
    suspend fun getPosts(): List<Post>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") postId: Int): Post

    @GET("posts/{id}/comments")
    suspend fun getPostComments(@Path("id") postId: Int): List<Comment>

    @GET("users/{id}")
    suspend fun getUser(@Path("id") userId: Int): User

    @GET("albums")
    suspend fun getAlbums(): List<AlbumRemote>

    @GET("photos")
    suspend fun getAllPhotos(): List<PhotoRemote>


    @GET("users")
    suspend fun getUsers(): List<User>

    @POST("/login")
    fun login(@Body request: LoginRequest): Response<User>
}


