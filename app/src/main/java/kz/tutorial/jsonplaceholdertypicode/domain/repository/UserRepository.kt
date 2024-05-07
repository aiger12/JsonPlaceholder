package kz.tutorial.jsonplaceholdertypicode.domain.repository

import kz.tutorial.jsonplaceholdertypicode.domain.entity.Token
import kz.tutorial.jsonplaceholdertypicode.domain.entity.User
import kz.tutorial.jsonplaceholdertypicode.domain.request.LoginRequest
import kz.tutorial.jsonplaceholdertypicode.domain.response.LoginTokenResponse
import retrofit2.Call
import retrofit2.Response

interface UserRepository {
    suspend fun getUser(userId: Int): User

    suspend fun getUsers(): List<User>

    suspend fun login(loginRequest: LoginRequest): Call<Response<LoginTokenResponse>>
}