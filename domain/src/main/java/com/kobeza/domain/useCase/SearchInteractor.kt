package com.kobeza.domain.useCase

import androidx.lifecycle.LiveData
import com.kobeza.domain.data.entity.SearchEntity
import com.kobeza.remote.data.response.SearchImageResponse
import com.kobeza.remote.repository.search.SearchRepository

class SearchInteractor(
    private val searchRepositoryRemote: SearchRepository
) : SearchUseCase {

    override suspend fun searchImageByQuery(query: String) {
        searchRepositoryRemote.searchImageByQuery(query)?.let {
            saveSearchHistoryToDb(query, it)
        }
    }

    override fun getAllImage(): LiveData<SearchEntity> {
        TODO("Not yet implemented")
    }

    private suspend fun saveSearchHistoryToDb(query: String, list: List<SearchImageResponse>) {

    }
}