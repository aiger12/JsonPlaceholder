package kz.tutorial.nedid.data.use_case

import kz.tutorial.nedid.constants.PREVIEW_COMMENTS_SIZE
import kz.tutorial.nedid.domain.entity.Comment
import kz.tutorial.nedid.domain.repository.PostsRepository
import kz.tutorial.nedid.domain.use_case.GetPostPreviewCommentsUseCase

class GetPostPreviewCommentsUseCaseImpl(private val repo: PostsRepository) : GetPostPreviewCommentsUseCase {
    override suspend fun invoke(postId: Int): List<Comment> {
        return repo.getPostComments(postId).take(PREVIEW_COMMENTS_SIZE)
    }
}