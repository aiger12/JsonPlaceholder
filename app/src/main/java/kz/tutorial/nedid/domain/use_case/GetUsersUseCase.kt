package kz.tutorial.nedid.domain.use_case

import kz.tutorial.nedid.domain.entity.User

interface GetUsersUseCase {
    suspend fun invoke(): List<User>
}