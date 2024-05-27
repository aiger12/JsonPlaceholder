package kz.tutorial.jsonplaceholdertypicode.presentation.profile

import UserPostAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Post
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsFragmentDirections
import kz.tutorial.jsonplaceholdertypicode.presentation.register.RetrofitClient
import kz.tutorial.jsonplaceholdertypicode.presentation.register.TokenManager
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration

class UserProfileFragment : Fragment() {
    lateinit var username: TextView
    lateinit var name: TextView
    lateinit var rvPosts: RecyclerView
//    lateinit var adapter: PostAdapter
    lateinit var postsAdapter: UserPostAdapter
    lateinit var myPosts : List<Post>
    lateinit var postCount: TextView



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_user_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        initViews(view)
        initAdapter()
        val token = TokenManager.getToken(requireContext())
        setValues(token)
        initRecycler()


    }

    private fun initViews(view: View) {
        username = view.findViewById(R.id.titleUsername)
        name = view.findViewById(R.id.titleName)
        rvPosts = view.findViewById(R.id.rv_posts)
        postCount = view.findViewById(R.id.postsNumber)
    }

    private fun setValues(token: String?){
        val userId = arguments?.getInt("user_id", 0)!!


        lifecycleScope.launch {
            val response = try {
                val user = RetrofitClient.apiService.getUser(userId)
                myPosts = RetrofitClient.apiService.getPostsByUserId(userId).data
                postCount.text = myPosts.size.toString()
                username.text = user.username
                name.text = user.name

                postsAdapter.setData(myPosts)
            } catch (e: Exception) {
                Log.d("ProfileFragment", "Error: ${e.message}")
                return@launch
            }
        }
    }
    private fun initAdapter() {
        postsAdapter = UserPostAdapter(layoutInflater, requireContext(), findNavController())
        postsAdapter.listener = ClickListener {
            val action = UserProfileFragmentDirections.actionUserProfileFragmentToPostDetails(it.id)
            findNavController().navigate(action)
        }
    }


    private fun initRecycler() {
        val currentContext = context ?: return

        rvPosts.adapter = postsAdapter
        rvPosts.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvPosts.addItemDecoration(spaceItemDecoration)
    }

}
