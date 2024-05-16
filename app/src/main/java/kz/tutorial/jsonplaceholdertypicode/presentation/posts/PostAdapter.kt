import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Post
import kz.tutorial.jsonplaceholdertypicode.presentation.register.RetrofitClient
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZonedDateTime

class PostAdapter(private val layoutInflater: LayoutInflater) :
    RecyclerView.Adapter<PostViewHolder>() {

    private val posts: MutableList<Post> = mutableListOf()
    var listener: ClickListener<Post>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = layoutInflater.inflate(R.layout.item_post, parent, false)

        return PostViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = posts[position]
        holder.bind(post)
        holder.itemView.setOnClickListener {
            listener?.onClick(post)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    fun setData(newData: List<Post>) {
        notifyItemRangeRemoved(0, posts.size)
        posts.clear()
        posts.addAll(newData)
        notifyItemRangeInserted(0, posts.size)
    }
}

class PostViewHolder(itemView: View) : ViewHolder(itemView) {
    private var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    private var tvBody: TextView = itemView.findViewById(R.id.tv_body)
    private var tvAuthor: TextView = itemView.findViewById(R.id.tv_author)
    private var tvDate: TextView = itemView.findViewById(R.id.tv_date)
    @RequiresApi(Build.VERSION_CODES.O)
    private fun formatPostCreationTime(creationTime: String): String {
        // Parse the creation time string into a LocalDateTime object
        val postCreationDateTime = ZonedDateTime.parse(creationTime).toLocalDateTime()

        // Get the current time
        val currentTime = LocalDateTime.now()

        // Calculate the duration between post creation time and current time
        val duration = Duration.between(postCreationDateTime, currentTime)

        // Determine the appropriate unit and format the output
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

    @RequiresApi(Build.VERSION_CODES.O)
    fun bind(post: Post) {
        tvTitle.text = post.title
        tvBody.text = post.body
        tvDate.text = formatPostCreationTime(post.createdAt)
//
//        // Launch a coroutine using GlobalScope
        GlobalScope.launch(Dispatchers.Main) {
            val user = RetrofitClient.apiService.getUser(post.userId)
            tvAuthor.text = user.username
        }
    }
}
