package kz.tutorial.nedid.domain.request

data class EditUserRequest(
    val username: String,
    val old_password: String,
    val new_password: String,
    val name: String,
    val LastName: String,
    val email: String
)

