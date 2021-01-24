package com.kobeza.local.repository.search

import androidx.lifecycle.LiveData
import com.kobeza.local.data.SearchLocal

interface ISearchRepository {

    suspend fun save(item: SearchLocal)

    fun getSearchHistory(): LiveData<List<SearchLocal>>
}