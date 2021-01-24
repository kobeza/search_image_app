package com.kobeza.remote.repository.search

import com.kobeza.remote.api.SearchImageApi
import com.kobeza.remote.data.response.SearchImageResponse
import com.kobeza.remote.repository.BaseRepository

class SearchRepository(
    private val api: SearchImageApi
) : BaseRepository(), ISearchRepository {

    override suspend fun searchImageByQuery(query: String): List<SearchImageResponse>? {
        return execute { api.searchImageByQueryAsync(query) }?.hits
    }
}