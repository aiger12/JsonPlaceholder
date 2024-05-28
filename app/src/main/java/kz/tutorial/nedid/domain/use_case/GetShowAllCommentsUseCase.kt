package kz.tutorial.nedid.domain.use_case

import kz.tutorial.nedid.domain.entity.Comment

interface GetShowAllCommentsUseCase {
    suspend fun invoke(postId: Int): List<Comment>
}