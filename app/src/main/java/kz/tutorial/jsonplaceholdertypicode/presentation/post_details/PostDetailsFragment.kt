package kz.tutorial.jsonplaceholdertypicode.presentation.post_details

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.constants.POST_ID_KEY
import kz.tutorial.jsonplaceholdertypicode.domain.request.AddCommentRequest
import kz.tutorial.jsonplaceholdertypicode.presentation.comments.CommentsAdapter
import kz.tutorial.jsonplaceholdertypicode.presentation.extensions.openEmailWithAddress
import kz.tutorial.jsonplaceholdertypicode.presentation.posts.PostsFragmentDirections
import kz.tutorial.jsonplaceholdertypicode.presentation.register.RetrofitClient
import kz.tutorial.jsonplaceholdertypicode.presentation.register.TokenManager
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime


class PostDetailsFragment : Fragment() {

    private val vm: PostDetailsViewModel by viewModel {
        parametersOf(arguments?.getInt(POST_ID_KEY, 0))
    }

    lateinit var rvComments: RecyclerView
    lateinit var tvTitle: TextView
    lateinit var tvAuthor: TextView
    lateinit var tvBody: TextView
    lateinit var tvShowAll: TextView
    lateinit var etAddComment: EditText
    lateinit var btnAddComment: Button
    lateinit var tvDate: TextView

    lateinit var commentsAdapter: CommentsAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_post_details, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()

        tvShowAll.setOnClickListener {
            val postId = arguments?.getInt(POST_ID_KEY)
            if (postId == null) return@setOnClickListener
            findNavController().navigate(PostDetailsFragmentDirections.actionPostDetailsToShowAllFragment(postId))
        }

        btnAddComment.setOnClickListener {
            val content = etAddComment.text.toString()
            if (content.length == 0) {
                Toast.makeText(
                    requireContext(),
                    "Comment must not be an empty!",
                    Toast.LENGTH_LONG
                ).show()

                return@setOnClickListener
            }

            val postId = arguments?.getInt(POST_ID_KEY)
            val token = TokenManager.getToken(requireContext())
            val tokenRequest = "Bearer $token"

            val request = AddCommentRequest(content, postId)

            lifecycleScope.launch {
                val response = try {
                    RetrofitClient.apiService.addComment(tokenRequest, request)
                } catch (e: Exception) {
                    Log.d("PostDetailsFragment", "Error: ${e.message}")
                    return@launch
                }
                if (response.isSuccessful) {
                    Toast.makeText(
                        requireContext(),
                        "Successfully added a comment!",
                        Toast.LENGTH_LONG
                    ).show()
                    findNavController().popBackStack()
                    findNavController().navigate(PostsFragmentDirections.toPostDetails(postId!!))
                } else {
                    Log.d("PostDetailsFragment", "Error: ${response.errorBody()?.string()}")
                }
            }
        }
    }

    private fun initViews(view: View) {
        rvComments = view.findViewById(R.id.rv_comments)
        tvTitle = view.findViewById(R.id.tv_title)
        tvAuthor = view.findViewById(R.id.tv_author)
        tvBody = view.findViewById(R.id.tv_body)
        tvShowAll = view.findViewById(R.id.tv_show_all)
        etAddComment = view.findViewById(R.id.et_add_comment)
        btnAddComment = view.findViewById(R.id.add_comment_btn)
        tvDate = view.findViewById(R.id.tv_date)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun formatPostCreationTime(creationTime: String): String {
        val postCreationDateTime = ZonedDateTime.parse(creationTime).withZoneSameInstant(ZoneId.of("UTC")).withZoneSameInstant(
            ZoneId.of("UTC+5")).toLocalDateTime()

        val currentTime = LocalDateTime.now(ZoneId.of("UTC+5"))

        val duration = Duration.between(postCreationDateTime, currentTime)

        return when {
            duration.toDays() >= 365 -> {
                val years = duration.toDays() / 365
                if (years > 1) "$years years ago" else "1 year ago"
            }
            duration.toDays() >= 30 -> {
                val months = duration.toDays() / 30
                if (months > 1) "$months months ago" else "1 month ago"
            }
            duration.toDays() >= 7 -> {
                val weeks = duration.toDays() / 7
                if (weeks > 1) "$weeks weeks ago" else "1 week ago"
            }
            duration.toDays() > 0 -> {
                val days = duration.toDays()
                if (days > 1) "$days days ago" else "1 day ago"
            }
            duration.toHours() > 0 -> {
                val hours = duration.toHours()
                if (hours > 1) "$hours hours ago" else "1 hour ago"
            }
            duration.toMinutes() > 0 -> {
                val minutes = duration.toMinutes()
                if (minutes > 1) "$minutes minutes ago" else "1 minute ago"
            }
            else -> "Just now"
        }
    }

    private fun initAdapter() {
        commentsAdapter = CommentsAdapter(layoutInflater) { email ->
            context?.openEmailWithAddress(email)
        }
    }

    private fun initRecycler() {
        val currentContext = context ?: return

        rvComments.adapter = commentsAdapter
        rvComments.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvComments.addItemDecoration(spaceItemDecoration)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun initObservers() {
        vm.postDetailsLiveData.observe(viewLifecycleOwner) { post ->
            tvTitle.text = post.title
            tvBody.text = post.body
            tvDate.text = formatPostCreationTime(post.createdAt)
        }
        vm.userLiveData.observe(viewLifecycleOwner) { user ->
            tvAuthor.text = user.username
        }
        vm.commentsLiveData.observe(viewLifecycleOwner) { comments ->
            commentsAdapter.submitList(comments)
        }
    }
}