package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kz.tutorial.jsonplaceholdertypicode.R
import kz.tutorial.jsonplaceholdertypicode.domain.entity.Photo
import kz.tutorial.jsonplaceholdertypicode.presentation.albums.AlbumsAdapter
import kz.tutorial.jsonplaceholdertypicode.presentation.utils.SpaceItemDecoration
import org.koin.androidx.viewmodel.ext.android.viewModel

class PhotoFragment : Fragment() {
    private val vm: PhotoViewModel by viewModel()
    private lateinit var adapter: PhotoAdapter
    private lateinit var rvPhoto: RecyclerView
    private lateinit var ivImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.item_photo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        initAdapter()
        initObservers()
        initViews(view)
    }

    private fun initViews(view: View){
        rvPhoto = view.findViewById(R.id.rv_photo)
    }
    private fun initRecycler(){
        val currentContext = context ?: return

        rvPhoto.adapter = adapter
        rvPhoto.layoutManager = LinearLayoutManager(currentContext)

        val spaceItemDecoration =
            SpaceItemDecoration(verticalSpaceInDp = 8, horizontalSpaceInDp = 16)
        rvPhoto.addItemDecoration(spaceItemDecoration)
    }
    private fun initAdapter(){
        adapter = PhotoAdapter(layoutInflater)
        adapter.listener
    }
    private fun initObservers(){
        vm.photoLiveData.observe(viewLifecycleOwner){

    }

            }
        }

