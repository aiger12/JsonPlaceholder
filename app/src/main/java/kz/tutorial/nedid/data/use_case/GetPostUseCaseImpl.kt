package kz.tutorial.nedid.data.use_case

import kz.tutorial.nedid.domain.entity.Post
import kz.tutorial.nedid.domain.repository.PostsRepository
import kz.tutorial.nedid.domain.use_case.GetPostUseCase

class GetPostUseCaseImpl(private val repository: PostsRepository) : GetPostUseCase {
    override suspend fun invoke(postId: Int): Post {
        return repository.getPost(postId)
    }
}