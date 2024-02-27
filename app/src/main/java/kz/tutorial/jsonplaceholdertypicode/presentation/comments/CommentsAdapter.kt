package kz.tutorial.jsonplaceholdertypicode.presentation.comments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Post
import kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo.PhotoDiffCallBack
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.EmailClickListener

class CommentsAdapter(
    private val layoutInflater: LayoutInflater,
    private val emailClickListener: EmailClickListener,
   // var listener: ClickListener<Comment>? = null

) : ListAdapter<Comment, CommentViewHolder>(CommentsDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = layoutInflater.inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view, emailClickListener)
    }

    override fun onBindViewHolder(viewHolder: CommentViewHolder, index: Int) {
        val comment = getItem(index)
        viewHolder.bind(comment)
    }
}