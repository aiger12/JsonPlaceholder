package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import androidx.recyclerview.widget.DiffUtil
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Album

class AlbumsDiffCallBack : DiffUtil.ItemCallback<Album>() {
    override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean {
        return  oldItem == newItem
    }

}