package kz.tutorial.jsonplaceholdertypicode.domain.use_case
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Token
import kz.tutorial.jsonplaceholdertypicode.domain.entity.User
import kz.tutorial.jsonplaceholdertypicode.domain.response.LoginTokenResponse
import retrofit2.Response

interface LoginUseCase {
    suspend fun login(username: String, password: String): Response<LoginTokenResponse>?
}