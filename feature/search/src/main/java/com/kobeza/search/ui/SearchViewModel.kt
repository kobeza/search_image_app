package com.kobeza.search.ui

import android.content.res.Resources
import androidx.lifecycle.MutableLiveData
import com.kobeza.core.base.BaseViewModel
import com.kobeza.domain.useCase.SearchUseCase
import com.kobeza.search.R
import com.kobeza.search.data.SearchState
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchUseCase: SearchUseCase,
    private var res: Resources
) : BaseViewModel() {

    val searchHistory = searchUseCase.getAllImage()

    val state = SearchState(
        MutableLiveData(),
        MutableLiveData()
    )

    fun onDoneButtonClick(query: String) {
        ioScope.launch {

            changeProgressBarState(true)

            searchUseCase.searchImageByQuery(query)?.let {

                changeProgressBarState(false)

                if (!it) {
                    state.errorMessage.postValue(res.getString(R.string.error_message_nothing_found))
                }
            } ?: searchErrorAction()
        }
    }

    private fun searchErrorAction() {
        changeProgressBarState(false)
        state.errorMessage.postValue(res.getString(R.string.error_message_oops_something_went_wrong))
    }

    private fun changeProgressBarState(isVisible: Boolean) {
        state.progressVisibility.postValue(isVisible)
    }
}