package kz.tutorial.nedid.domain.response

import kz.tutorial.nedid.domain.entity.Post

data class GetPostsResponse(
    val status: String,
    val data: List<Post>
)
