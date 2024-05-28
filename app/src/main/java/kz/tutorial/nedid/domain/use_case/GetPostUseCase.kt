package kz.tutorial.nedid.domain.use_case

import kz.tutorial.nedid.domain.entity.Post

interface GetPostUseCase {
    suspend fun invoke(postId: Int): Post
}