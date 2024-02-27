package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import kz.tutorial.jsonplaceholdertypicode.domain.use_case.GetPhotoUseCase

class PhotoViewModel(
    private val getPhotosUseCase: GetPhotoUseCase,
    private val id_album: Int): ViewModel() {

    private val _photoLiveData: MutableLiveData<PhotoTaker> = MutableLiveData()
    val photoLiveData: LiveData<PhotoTaker> = _photoLiveData

    init {
        getPhoto()
    }

    private fun getPhoto(){
        _photoLiveData.postValue(PhotoTaker.Loading)
        viewModelScope.launch{
                val photos= getPhotosUseCase.getPhotos()
                val photoList = if (photos != null) {
                    photos.filter { it.albumId == id_album }
                } else {
                    null
                }
        }
    }

    fun updateLayout(liner:LayoutStatus){
        _photoLiveData.postValue(PhotoTaker.changeLayout(liner))
    }
    }




