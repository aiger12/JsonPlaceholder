package kz.tutorial.jsonplaceholdertypicode.data.repository

import kz.tutorial.jsonplaceholdertypicode.data.network.MainApi
import kz.tutorial.jsonplaceholdertypicode.domain.entity.User
import kz.tutorial.jsonplaceholdertypicode.domain.repository.UserRepository
import kz.tutorial.jsonplaceholdertypicode.domain.request.LoginRequest
import retrofit2.Response

class UserRepositoryImpl(
    private val mainApi: MainApi,
) : UserRepository {
    override suspend fun getUser(userId: Int): User {
        return mainApi.getUser(userId)
    }

    override suspend fun getUsers(): List<User> {
        return mainApi.getUsers()
    }

    override suspend fun login(loginRequest: LoginRequest): Response<User> {
        return mainApi.login(loginRequest)
    }
}