package kz.tutorial.nedid.domain.use_case

import kz.tutorial.nedid.domain.entity.Post

interface GetPostsUseCase {
    suspend fun invoke(): List<Post>
}