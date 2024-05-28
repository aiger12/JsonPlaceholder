package kz.tutorial.nedid.domain.use_case

import kz.tutorial.nedid.domain.entity.Album

interface GetAlbumsUseCase {
    suspend fun invoke(): List<Album>
}