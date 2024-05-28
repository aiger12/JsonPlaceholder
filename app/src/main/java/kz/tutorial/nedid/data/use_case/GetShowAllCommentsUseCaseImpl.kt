package kz.tutorial.nedid.data.use_case

import kz.tutorial.nedid.domain.entity.Comment
import kz.tutorial.nedid.domain.repository.PostsRepository
import kz.tutorial.nedid.domain.use_case.GetShowAllCommentsUseCase

class GetShowAllCommentsUseCaseImpl(private val repo: PostsRepository):GetShowAllCommentsUseCase {
    override suspend fun invoke(postId: Int): List<Comment> {
        return repo.getPostComments(postId)
    }
}