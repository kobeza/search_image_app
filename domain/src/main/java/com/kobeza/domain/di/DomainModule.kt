package com.kobeza.domain.di

import com.kobeza.domain.useCase.SearchInteractor
import com.kobeza.local.di.LocalModule
import com.kobeza.remote.di.RemoteModule
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

object DomainModule {
    fun get() = Kodein.Module("DomainModule") {

        import(RemoteModule.get())
        import(LocalModule.get())

        bind() from provider { SearchInteractor(instance()) }
    }
}