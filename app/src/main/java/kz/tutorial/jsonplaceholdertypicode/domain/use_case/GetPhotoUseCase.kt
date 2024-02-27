package kz.tutorial.jsonplaceholdertypicode.domain.use_case

import kz.tutorial.jsonplaceholdertypicode.domain.entity.Photo

interface GetPhotoUseCase {
    suspend fun getPhotos(): List<Photo>
    suspend fun getPhoto(id:Int): Photo
}