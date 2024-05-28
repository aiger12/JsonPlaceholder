package kz.tutorial.nedid.domain.repository

import kz.tutorial.nedid.domain.entity.Comment
import kz.tutorial.nedid.domain.entity.Post

interface PostsRepository {
    suspend fun getPosts(): List<Post>

    suspend fun getPost(postId: Int): Post

    suspend fun getPostComments(postId: Int): List<Comment>
}