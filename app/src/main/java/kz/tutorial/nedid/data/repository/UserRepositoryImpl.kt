package kz.tutorial.nedid.data.repository

import kz.tutorial.nedid.data.network.MainApi
import kz.tutorial.nedid.domain.entity.User
import kz.tutorial.nedid.domain.repository.UserRepository

class UserRepositoryImpl(
    private val mainApi: MainApi,
) : UserRepository {
    override suspend fun getUser(userId: Int): User {
        return mainApi.getUser(userId)
    }

    override suspend fun getUsers(): List<User> {
        return mainApi.getUsers()
    }
}