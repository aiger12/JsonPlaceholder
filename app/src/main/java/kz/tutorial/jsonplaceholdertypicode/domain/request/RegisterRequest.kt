package kz.tutorial.jsonplaceholdertypicode.domain.request

data class RegisterRequest(val email: String, val username: String, val firstname: String,
                           val lastname: String, val password: String)
