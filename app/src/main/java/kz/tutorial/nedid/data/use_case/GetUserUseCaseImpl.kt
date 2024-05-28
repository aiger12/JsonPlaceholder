package kz.tutorial.nedid.data.use_case

import kz.tutorial.nedid.domain.entity.User
import kz.tutorial.nedid.domain.repository.UserRepository
import kz.tutorial.nedid.domain.use_case.GetUserUseCase

class GetUserUseCaseImpl(private val userRepository: UserRepository) : GetUserUseCase {
    override suspend fun invoke(userId: Int): User {
        return userRepository.getUser(userId)
    }

}