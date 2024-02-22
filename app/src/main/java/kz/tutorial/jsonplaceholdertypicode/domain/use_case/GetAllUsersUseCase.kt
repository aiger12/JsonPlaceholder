package kz.tutorial.jsonplaceholdertypicode.domain.use_case

import kz.tutorial.jsonplaceholdertypicode.domain.entity.User

interface GetAllUsersUseCase {
    suspend fun invoke(): List<User>
}