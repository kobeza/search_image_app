package com.kobeza.remote.repository.search

import com.kobeza.remote.data.response.SearchImageResponse

interface ISearchRepository {
    suspend fun searchImageByQuery(query: String): List<SearchImageResponse>?
}