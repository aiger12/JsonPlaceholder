package kz.tutorial.nedid.domain.request

data class AddCommentRequest(
    val Content: String,
    val PostID: Int?
)
