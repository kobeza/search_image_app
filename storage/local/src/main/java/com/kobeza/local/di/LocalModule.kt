package com.kobeza.local.di

import androidx.room.Room
import com.kobeza.local.LocalDatabase
import com.kobeza.local.repository.search.ISearchRepository
import com.kobeza.local.repository.search.SearchDao
import com.kobeza.local.repository.search.SearchRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

object LocalModule {
    fun get() = Kodein.Module("LocalModule") {
        bind<LocalDatabase>() with singleton {
            Room.databaseBuilder<LocalDatabase>(
                instance(),
                LocalDatabase::class.java,
                LocalDatabase.DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }

        bind<SearchDao>() with provider { instance<LocalDatabase>().searchDao() }
        bind<ISearchRepository>() with provider { SearchRepository(instance()) }
    }
}