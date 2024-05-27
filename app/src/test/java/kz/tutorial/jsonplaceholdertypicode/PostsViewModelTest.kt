import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import kz.tutorial.jsonplaceholdertypicode.data.use_case.GetPostUseCaseImpl
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Post
import kz.tutorial.jsonplaceholdertypicode.domain.repository.PostsRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetPostUseCaseImplTest {

    @Mock
    lateinit var repository: PostsRepository

    private lateinit var useCase: GetPostUseCaseImpl

    @Before
    fun setUp() {
        useCase = GetPostUseCaseImpl(repository)
    }

    @Test
    fun `invoke() should return post`() {
        val postId = 1
        val expectedPost = Post("Body", postId, "Title", 1, "2024-05-27")

        runBlocking {
            // Mock the repository response within a coroutine context
            Mockito.`when`(repository.getPost(postId)).thenReturn(expectedPost)

            // Invoke the use case
            val result = useCase.invoke(postId)

            // Verify that the repository method is called with the correct parameters
            Mockito.verify(repository).getPost(postId)

            // Verify that the result matches the expected post
            assertEquals(expectedPost, result)
        }
    }

}
