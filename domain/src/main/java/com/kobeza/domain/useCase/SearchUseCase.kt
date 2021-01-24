package com.kobeza.domain.useCase

import androidx.lifecycle.LiveData
import com.kobeza.domain.data.entity.SearchEntity

interface SearchUseCase {
    suspend fun searchImageByQuery(query:String)

    fun getAllImage(): LiveData<SearchEntity>
}