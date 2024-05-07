package kz.tutorial.jsonplaceholdertypicode.data.repository

import android.util.Log
import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Token
import kz.tutorial.jsonplaceholdertypicode.domain.entity.User
import kz.tutorial.jsonplaceholdertypicode.domain.repository.UserRepository
import kz.tutorial.jsonplaceholdertypicode.domain.request.LoginRequest
import kz.tutorial.jsonplaceholdertypicode.domain.response.LoginTokenResponse
import retrofit2.Call
import retrofit2.Response
import kotlin.system.exitProcess

class UserRepositoryImpl(
    private val mainApi: MainApi,
) : UserRepository {
    override suspend fun getUser(userId: Int): User {
        return mainApi.getUser(userId)
    }

    override suspend fun getUsers(): List<User> {
        return mainApi.getUsers()
    }

    override suspend fun login(loginRequest: LoginRequest): Call<Response<LoginTokenResponse>> {
        return mainApi.login(loginRequest)
    }
}