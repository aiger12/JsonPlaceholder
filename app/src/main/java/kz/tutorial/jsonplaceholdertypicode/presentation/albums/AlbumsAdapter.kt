package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import androidx.recyclerview.widget.ListAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Album
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListenerWithThree

class AlbumsAdapter(
    private val layoutInflater: LayoutInflater):
    ListAdapter<Album, AlbumsViewHolder>(AlbumsDiffCallBack()){
    private val albums: MutableList<Album> = mutableListOf()
    var listener: ClickListener<Album>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder{
        val view = layoutInflater.inflate(R.layout.ittem_albums,parent,false)
        return AlbumsViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int){
        val album = getItem(position)
        holder.bind(album)
        holder.itemView.setOnClickListener{
            listener?.onClick(album)
        }

    }
    }