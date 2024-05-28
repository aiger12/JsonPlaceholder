package kz.tutorial.nedid.data.use_case

import kz.tutorial.nedid.domain.entity.Album
import kz.tutorial.nedid.domain.repository.PhotoRepository
import kz.tutorial.nedid.domain.use_case.GetAlbumsUseCase

class GetAlbumsUseCaseImpl(private val photoRepository: PhotoRepository) : GetAlbumsUseCase {
    override suspend fun invoke(): List<Album> {
        return photoRepository.getAlbums()
    }
}