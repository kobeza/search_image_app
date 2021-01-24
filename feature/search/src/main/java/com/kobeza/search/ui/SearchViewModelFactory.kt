package com.kobeza.search.ui

import android.content.res.Resources
import com.kobeza.core.base.BaseViewModelFactory
import com.kobeza.domain.useCase.SearchUseCase

class SearchViewModelFactory(
    private val searchUseCase: SearchUseCase,
    private val res: Resources
) : BaseViewModelFactory<SearchViewModel>() {
    override fun createViewModel() = SearchViewModel(
        searchUseCase = searchUseCase,
        res = res
    )
}