package kz.tutorial.jsonplaceholdertypicode.data.network

import kz.tutorial.jsonplaceholdertypicode.data.entity.AlbumRemote
import kz.tutorial.jsonplaceholdertypicode.data.entity.PhotoRemote
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Post
import kz.tutorial.jsonplaceholdertypicode.domain.entity.User
import kz.tutorial.jsonplaceholdertypicode.domain.request.AddPostRequest
import kz.tutorial.jsonplaceholdertypicode.domain.request.EditUserRequest
import kz.tutorial.jsonplaceholdertypicode.domain.request.LoginRequest
import kz.tutorial.jsonplaceholdertypicode.domain.request.RegisterRequest
import kz.tutorial.jsonplaceholdertypicode.domain.response.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
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

    @POST("users/login")
    suspend fun login(@Body request: LoginRequest): Response<LoginResponse>

    @POST("users/signup")
    suspend fun register(@Body request: RegisterRequest): Response<Any>

    @POST("posts/add")
    suspend fun addPost(
        @Header("Authorization") token: String?,
        @Body request: AddPostRequest
    ): Response<Any>

    @PUT("users/edit_profile")
    suspend fun editUser(
        @Header("Authorization") token: String?,
        @Body request: EditUserRequest

    ): Response<Any>

}