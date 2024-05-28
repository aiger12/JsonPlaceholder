package kz.tutorial.nedid.data.use_case

import kz.tutorial.nedid.domain.use_case.GetPostsUseCase
import kz.tutorial.nedid.domain.entity.Post
import kz.tutorial.nedid.domain.repository.PostsRepository

class GetPostsUseCaseImpl(private val postsRepository: PostsRepository) : GetPostsUseCase {
    override suspend fun invoke(): List<Post> {
        return postsRepository.getPosts()
    }
}