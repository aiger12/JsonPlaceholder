package kz.tutorial.nedid.domain.use_case

import kz.tutorial.nedid.domain.entity.User

interface GetUserUseCase {
    suspend fun invoke(userId: Int): User
}