package com.kobeza.local.repository.search

import androidx.lifecycle.LiveData
import com.kobeza.local.data.SearchLocal

class SearchRepository(
    private val dao: SearchDao
) : ISearchRepository {

    override suspend fun save(item: SearchLocal) {
        dao.save(item)
    }

    override fun getSearchHistory(): LiveData<List<SearchLocal>> {
        return dao.getSearchHistory()
    }
}