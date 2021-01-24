package com.kobeza.searchimage.di

import android.app.Application
import com.kobeza.domain.di.DomainModule
import org.kodein.di.Kodein
import org.kodein.di.android.androidModule

object AppModule {
    fun get(app: Application) = Kodein.Module("AppModule") {

        import(androidModule(app))
        import(DomainModule.get())
    }
}

