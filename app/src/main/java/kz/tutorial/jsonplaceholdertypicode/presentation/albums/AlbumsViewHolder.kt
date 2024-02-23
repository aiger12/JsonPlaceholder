package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.view.View
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Album
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.AlbumClickListener

class AlbumsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private var albumsName: TextView = itemView.findViewById(R.id.albums_name)
    private var albumsUser: TextView = itemView.findViewById(R.id.albums_users)
    private var albumsImage: ImageView = itemView.findViewById(R.id.albums_image)

    fun bind(album: Album) {
        albumsName.text = album.title
        albumsUser.text = album.username
        Glide.with(itemView).load(album.photoUrl).into(albumsImage)
    }
}