package com.kobeza.local.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SearchLocal(
    @PrimaryKey
    val imageUrl: String,
    val query: String,
    val timestamp: Long = System.currentTimeMillis()
)