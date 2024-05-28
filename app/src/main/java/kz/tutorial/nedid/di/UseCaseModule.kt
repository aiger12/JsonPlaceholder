package kz.tutorial.nedid.di

import kz.tutorial.nedid.data.use_case.GetAlbumsUseCaseImpl
import kz.tutorial.nedid.data.use_case.GetAllUsersUseCaseImpl
import kz.tutorial.nedid.data.use_case.GetPostPreviewCommentsUseCaseImpl
import kz.tutorial.nedid.data.use_case.GetPostUseCaseImpl
import kz.tutorial.nedid.data.use_case.GetPostsUseCaseImpl
import kz.tutorial.nedid.data.use_case.GetShowAllCommentsUseCaseImpl
import kz.tutorial.nedid.data.use_case.GetUserUseCaseImpl
import kz.tutorial.nedid.domain.use_case.GetAlbumsUseCase
import kz.tutorial.nedid.domain.use_case.GetUsersUseCase
import kz.tutorial.nedid.domain.use_case.GetPostPreviewCommentsUseCase
import kz.tutorial.nedid.domain.use_case.GetPostUseCase
import kz.tutorial.nedid.domain.use_case.GetPostsUseCase
import kz.tutorial.nedid.domain.use_case.GetShowAllCommentsUseCase
import kz.tutorial.nedid.domain.use_case.GetUserUseCase
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetPostsUseCase> { GetPostsUseCaseImpl(get()) }
    factory<GetPostUseCase> { GetPostUseCaseImpl(get()) }
    factory<GetPostPreviewCommentsUseCase> { GetPostPreviewCommentsUseCaseImpl(get()) }
    factory<GetUserUseCase> { GetUserUseCaseImpl(get()) }
    factory<GetAlbumsUseCase> { GetAlbumsUseCaseImpl(get()) }
    factory<GetShowAllCommentsUseCase> { GetShowAllCommentsUseCaseImpl(get()) }
    factory<GetUsersUseCase> { GetAllUsersUseCaseImpl(get()) }
}