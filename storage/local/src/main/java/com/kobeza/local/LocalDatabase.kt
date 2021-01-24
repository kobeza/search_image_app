package com.kobeza.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kobeza.local.data.SearchLocal
import com.kobeza.local.repository.search.SearchDao

@Database(
    entities = [
        SearchLocal::class
    ],
    version = 3
)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun searchDao(): SearchDao

    companion object {
        const val DATABASE_NAME = "SearchImageDB"
    }
}