package kz.tutorial.jsonplaceholdertypicode.presentation.albums.photo

import kz.tutorial.jsonplaceholdertypicode.domain.entity.Photo

sealed class PhotoTaker {

    data class Success(val listPhoto:List<Photo>): PhotoTaker()

    data class Error(val error: String): PhotoTaker()

    data class changeLayout(val layout:LayoutStatus):PhotoTaker()

    object Loading: PhotoTaker()
}


enum class LayoutStatus {
    LinerLayout,
    GridLayout
}