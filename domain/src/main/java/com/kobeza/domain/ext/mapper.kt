package com.kobeza.domain.ext

import com.kobeza.domain.data.entity.SearchEntity
import com.kobeza.local.data.SearchLocal
import com.kobeza.remote.data.response.SearchImageResponse

fun SearchLocal.toEntity(): SearchEntity {
    return SearchEntity(
        imageUrl = imageUrl,
        query = query
    )
}

fun SearchImageResponse.toLocal(query:String):SearchLocal{
    return SearchLocal(
        imageUrl = previewURL.orEmpty(),
        query = query
    )
}