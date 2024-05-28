package kz.tutorial.nedid.domain.repository

import kz.tutorial.nedid.domain.entity.Album

interface PhotoRepository {
    suspend fun getAlbums(): List<Album>

}