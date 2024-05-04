package kz.tutorial.jsonplaceholdertypicode.data.use_case

import kz.tutorial.jsonplaceholdertypicode.domain.entity.Token
import kz.tutorial.jsonplaceholdertypicode.domain.entity.User
import kz.tutorial.jsonplaceholdertypicode.domain.repository.UserRepository
import kz.tutorial.jsonplaceholdertypicode.domain.request.LoginRequest
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.LoginUseCase
import retrofit2.Response
import timber.log.Timber
import javax.security.auth.login.LoginException

class LoginUseCaseImpl(private val userRepository: UserRepository) : LoginUseCase {
    override suspend fun login(username: String, password: String): Response<Token>? {
        val loginRequest = LoginRequest(username, password)
        val response = userRepository.login(loginRequest).execute()
            return response.body()
    }
}
