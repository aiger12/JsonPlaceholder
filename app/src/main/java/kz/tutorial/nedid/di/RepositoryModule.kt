package kz.tutorial.nedid.di

import kz.tutorial.nedid.data.repository.PhotoRepositoryImpl
import kz.tutorial.nedid.data.repository.PostsRepositoryImpl
import kz.tutorial.nedid.data.repository.UserRepositoryImpl
import kz.tutorial.nedid.domain.repository.PostsRepository
import kz.tutorial.nedid.domain.repository.UserRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<PostsRepository> { PostsRepositoryImpl(get()) }
    factory<UserRepository> { UserRepositoryImpl(get()) }
    factory<PhotoRepositoryImpl> {
        PhotoRepositoryImpl(
            mainApi = get(),
            userRepository = get(),
            albumMapper = get()
        )
    }
}