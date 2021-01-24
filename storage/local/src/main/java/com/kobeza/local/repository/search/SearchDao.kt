package com.kobeza.local.repository.search

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kobeza.local.data.SearchLocal

@Dao
interface SearchDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun save(item: SearchLocal)

    @Query("SELECT * FROM SearchLocal ORDER BY timestamp DESC")
    fun getSearchHistory(): LiveData<List<SearchLocal>>
}