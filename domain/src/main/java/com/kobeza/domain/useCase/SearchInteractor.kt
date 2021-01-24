package com.kobeza.domain.useCase

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.kobeza.domain.data.entity.SearchEntity
import com.kobeza.domain.ext.toEntity
import com.kobeza.domain.ext.toLocal
import com.kobeza.remote.data.response.SearchImageResponse
import com.kobeza.remote.repository.search.ISearchRepository

class SearchInteractor(
    private val searchRepositoryRemote: ISearchRepository,
    private val searchRepositoryLocal: com.kobeza.local.repository.search.ISearchRepository
) : SearchUseCase {

    override suspend fun searchImageByQuery(query: String):Boolean? {
        return searchRepositoryRemote.searchImageByQuery(query)?.let {
            saveSearchHistoryItemToDb(query, it)
            it.isNotEmpty()
        }
    }

    override fun getAllImage(): LiveData<List<SearchEntity>> {
        return Transformations.map(searchRepositoryLocal.getSearchHistory()) {
            it.map { it.toEntity() }
        }
    }

    private suspend fun saveSearchHistoryItemToDb(query: String, list: List<SearchImageResponse>) {
        list.firstOrNull()?.let {
            it.toLocal(query).let {
                searchRepositoryLocal.save(it)
            }
        }
    }
}