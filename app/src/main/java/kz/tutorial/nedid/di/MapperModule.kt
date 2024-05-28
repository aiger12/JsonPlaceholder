package kz.tutorial.nedid.di

import kz.tutorial.nedid.data.mapper.AlbumMapper
import kz.tutorial.nedid.data.mapper.AlbumMapperImpl
import org.koin.dsl.module

val mapperModule = module {
    factory<AlbumMapper> { AlbumMapperImpl() }
}