package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo

import androidx.recyclerview.widget.DiffUtil
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Comment
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Photo

class PhotoDiffCallBack : DiffUtil.ItemCallback<Photo>() {
    override fun areItemsTheSame(p0: Photo, p1: Photo): Boolean {
        return p0.id == p1.id
    }

    override fun areContentsTheSame(p0: Photo, p1: Photo): Boolean {
        return p0 == p1
    }
}