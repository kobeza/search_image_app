package com.kobeza.remote.repository.search

import com.kobeza.remote.api.SearchImageApi
import com.kobeza.remote.repository.BaseRepository

class SearchRepository(
    private val api: SearchImageApi
) : BaseRepository(), ISearchRepository {
}