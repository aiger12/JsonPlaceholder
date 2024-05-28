package kz.tutorial.nedid.data.repository

import kz.tutorial.nedid.data.mapper.AlbumMapper
import kz.tutorial.nedid.data.network.MainApi
import kz.tutorial.nedid.domain.entity.Album
import kz.tutorial.nedid.domain.repository.PhotoRepository
import kz.tutorial.nedid.domain.repository.UserRepository

class PhotoRepositoryImpl(
    private val mainApi: MainApi,
    private val userRepository: UserRepository,
    private val albumMapper: AlbumMapper,
) : PhotoRepository {
    override suspend fun getAlbums(): List<Album> {
        val remoteAlbums = mainApi.getAlbums()
        val users = userRepository.getUsers()
        val photos = mainApi.getAllPhotos()

        return albumMapper.toDomain(remoteAlbums, users, photos)
    }
}