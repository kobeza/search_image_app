package com.kobeza.search.di

import androidx.lifecycle.ViewModelProvider
import com.kobeza.search.ui.SearchActivity
import com.kobeza.search.ui.SearchViewModel
import com.kobeza.search.ui.SearchViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

object SearchModule {
    fun get(activity: SearchActivity) = Kodein.Module("SearchModule") {

        bind<ViewModelProvider.Factory>() with singleton {
            SearchViewModelFactory(
                searchUseCase = instance(),
                res = instance()
            )
        }

        bind<SearchViewModel>() with singleton {
            activity.vm(instance())
        }
    }
}