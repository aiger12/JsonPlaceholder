package kz.tutorial.jsonplaceholdertypicode.presentation.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.ClickListener
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class AlbumsFragment : Fragment(R.layout.fragment_albums) {

    private val vm: AlbumsViewModel by viewModel()

    lateinit var adapter: AlbumsAdapter
    lateinit var rvAlbums: RecyclerView
    lateinit var ivImage: ImageView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_albums, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        assignViews(view)
        initViews(view)
        initAdapter()
        initRecycler()
        initObservers()
    }


    private fun initViews(view: View) {
        rvAlbums = view.findViewById(R.id.rv_albums)
    }

    private fun initAdapter(){
        adapter = AlbumsAdapter(layoutInflater)
        adapter.listener = ClickListener {

        }

    }

    private fun initRecycler(){
        val currentContext = context ?: return

        rvAlbums.adapter = adapter
        rvAlbums.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvAlbums.addItemDecoration(spaceItemDecoration)
    }

    private fun initObservers(){
        vm.albumsLiveData.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }


    private fun assignViews(view: View) {
//        ivImage = view.findViewById(R.id.albums_image)

//        val imageUrl =
//            "https://images.genius.com/2b790e48bcd9779bce4dc5bc74a01118.563x1000x1.png"
//        Glide.with(this)
//            .load(imageUrl)
//            .into(ivImage)
    }

}