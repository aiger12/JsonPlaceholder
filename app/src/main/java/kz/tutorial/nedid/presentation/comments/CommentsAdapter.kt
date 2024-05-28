package kz.tutorial.nedid.presentation.comments

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.recyclerview.widget.ListAdapter
import kz.tutorial.nedid.R
import kz.tutorial.nedid.domain.entity.Comment

class CommentsAdapter(
    private val layoutInflater: LayoutInflater,
    private val navController: NavController,
    private val isShowAll: Boolean
) : ListAdapter<Comment, CommentViewHolder>(CommentsDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = layoutInflater.inflate(R.layout.item_comment, parent, false)
        return CommentViewHolder(view, navController, isShowAll)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(viewHolder: CommentViewHolder, index: Int) {
        val comment = getItem(index)
        viewHolder.bind(comment)
    }
}