package kz.tutorial.nedid.domain.request

data class RegisterRequest(val username: String, val name: String,val LastName: String,
                           val email: String, val password: String)
