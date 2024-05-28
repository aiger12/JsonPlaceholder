package kz.tutorial.nedid.data.use_case

import kz.tutorial.nedid.domain.entity.User
import kz.tutorial.nedid.domain.repository.UserRepository
import kz.tutorial.nedid.domain.use_case.GetUsersUseCase

class GetAllUsersUseCaseImpl (private val usersRepository:UserRepository) : GetUsersUseCase {
    override suspend fun invoke(): List<User> {
        return usersRepository.getUsers()
    }
}