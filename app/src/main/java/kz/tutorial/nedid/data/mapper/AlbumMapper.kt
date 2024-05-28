package kz.tutorial.nedid.data.mapper

import kz.tutorial.nedid.data.entity.AlbumRemote
import kz.tutorial.nedid.data.entity.PhotoRemote
import kz.tutorial.nedid.domain.entity.Album
import kz.tutorial.nedid.domain.entity.User

interface AlbumMapper {
    fun toDomain(albumRemote: AlbumRemote, user: User, previewPhoto: PhotoRemote): Album

    fun toDomain(albums: List<AlbumRemote>, users: List<User>, photos: List<PhotoRemote>): List<Album>
}