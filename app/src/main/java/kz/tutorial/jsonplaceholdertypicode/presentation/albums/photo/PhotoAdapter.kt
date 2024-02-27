package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Photo
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener

class PhotoAdapter(
    private val layoutInflater: LayoutInflater):
    ListAdapter<Photo, PhotoAdapter.PhotoViewHolder>(PhotoDiffCallBack()) {

    private val photo: MutableList<Photo> = mutableListOf()
    var listener: ClickListener<Photo>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val view = layoutInflater.inflate(R.layout.item_photo,parent,false)
        return PhotoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val photo = getItem(position)
        holder.bind(photo)
        holder.itemView.setOnClickListener {
            listener?.onClick(photo)
        }
    }

    class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val photoImage: ImageView = itemView.findViewById(R.id.photo_image)
        private val photoTitle: TextView = itemView.findViewById(R.id.photo_title)
        fun bind(photo: Photo){
            //правильный ли URL ?
                photoTitle.text = photo.title
                Glide.with(itemView).load(photo.thumbnailUrl).into(photoImage)
            }
        }

    }


