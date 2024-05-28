package kz.tutorial.nedid.data.repository

import kz.tutorial.nedid.data.network.MainApi
import kz.tutorial.nedid.domain.entity.Comment
import kz.tutorial.nedid.domain.entity.Post
import kz.tutorial.nedid.domain.repository.PostsRepository

class PostsRepositoryImpl(private val mainApi: MainApi) : PostsRepository {

    override suspend fun getPosts(): List<Post> {
        return mainApi.getPosts()
    }

    override suspend fun getPost(postId: Int): Post {
        return mainApi.getPost(postId)
    }

    override suspend fun getPostComments(postId: Int): List<Comment> {
        return mainApi.getPostComments(postId).reversed()
    }

}