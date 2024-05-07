package kz.tutorial.jsonplaceholdertypicode.domain.response

import com.google.gson.annotations.SerializedName

data class LoginTokenResponse(
    @SerializedName("token") val token: String
)
