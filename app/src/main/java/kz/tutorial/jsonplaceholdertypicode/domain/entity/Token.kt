package kz.tutorial.jsonplaceholdertypicode.domain.entity

import com.google.gson.annotations.SerializedName


data class Token(
    @SerializedName("token")
    val token: String?
)