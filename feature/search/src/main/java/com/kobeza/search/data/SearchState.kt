package com.kobeza.search.data

import androidx.lifecycle.MutableLiveData

data class SearchState(
    val progressVisibility: MutableLiveData<Boolean>,
    val errorMessage:MutableLiveData<String>
)