package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R

class AlbumsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private var albumsName: TextView = itemView.findViewById(R.id.albums_name)
    private var albumsUser: TextView = itemView.findViewById(R.id.albums_users)
    private var albumsImage: ImageView = itemView.findViewById(R.id.albums_image)
//    private var albumsUser: TextView = itemView.findViewById(R.id.albums_users)
//    private var albumsImage: ImageView = itemView.findViewById(R.id.albums_image)

    fun bind(album: Album) {
        albumsName.text = album.title
        albumsUser.text = album.userName
        Glide.with(itemView).load(album.photoUrl).into(AlbumsImage)
    }
}