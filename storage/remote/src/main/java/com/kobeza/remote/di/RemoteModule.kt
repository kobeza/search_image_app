package com.kobeza.remote.di

import com.kobeza.remote.AuthInterceptor
import com.kobeza.remote.api.SearchImageApi
import com.kobeza.remote.repository.search.ISearchRepository
import com.kobeza.remote.repository.search.SearchRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import retrofit2.Retrofit

object RemoteModule {
    fun get() = Kodein.Module("RemoteModule") {

        import(RetrofitModule.get())

        bind() from provider {
            AuthInterceptor()
        }

        bind<SearchImageApi>() with provider { instance<Retrofit>().create(SearchImageApi::class.java) }
        bind<ISearchRepository>() with provider { SearchRepository(instance()) }
    }
}