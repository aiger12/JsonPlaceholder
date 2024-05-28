package kz.tutorial.nedid.domain.repository

import kz.tutorial.nedid.domain.entity.User

interface UserRepository {
    suspend fun getUser(userId: Int): User

    suspend fun getUsers(): List<User>
}