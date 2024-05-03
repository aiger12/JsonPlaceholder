package kz.tutorial.jsonplaceholdertypicode.data.use_case

import kz.tutorial.jsonplaceholdertypicode.domain.entity.User
import kz.tutorial.jsonplaceholdertypicode.domain.repository.UserRepository
import kz.tutorial.jsonplaceholdertypicode.domain.request.LoginRequest
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.LoginUseCase
import javax.security.auth.login.LoginException

class LoginUseCaseImpl(private val userRepository: UserRepository) : LoginUseCase {
    override suspend fun login(username: String, password: String): User {
        val loginRequest = LoginRequest(username, password)
        val response = userRepository.login(loginRequest)

        if (response.isSuccessful) {
            return response.body()!!
        } else {

            throw LoginException("Login failed: ${response.code()}")
        }
    }
}
