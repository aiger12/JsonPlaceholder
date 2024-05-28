package kz.tutorial.nedid.presentation.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.nedid.domain.use_case.GetPostsUseCase
import kz.tutorial.nedid.domain.entity.Post

class PostsViewModel(private val getPostsUseCase: GetPostsUseCase) : ViewModel() {

    val _postsLiveData: MutableLiveData<List<Post>> = MutableLiveData()
    val postsLiveData: LiveData<List<Post>> = _postsLiveData

    init {
        getPosts()
    }

    fun getPosts() {
    }

}