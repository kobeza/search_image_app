package com.kobeza.remote.api

import com.kobeza.remote.data.response.DataWrapper
import com.kobeza.remote.data.response.SearchImageResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchImageApi {

    @GET("api/")
    fun searchImageByQueryAsync(@Query("q") query: String): Deferred<Response<DataWrapper<List<SearchImageResponse>>?>>
}