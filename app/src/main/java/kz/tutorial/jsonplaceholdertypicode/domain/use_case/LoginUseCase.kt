package kz.tutorial.jsonplaceholdertypicode.domain.use_case
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Token
import kz.tutorial.jsonplaceholdertypicode.domain.entity.User

interface LoginUseCase {
    suspend fun login(username: String, password: String): Token
}