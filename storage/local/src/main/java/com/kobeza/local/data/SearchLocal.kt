package com.kobeza.local.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SearchLocal(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val imageUrl: String,
    val query: String
)