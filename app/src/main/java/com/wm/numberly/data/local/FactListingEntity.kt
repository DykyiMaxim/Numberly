package com.wm.numberly.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FactsTable")
data class FactListingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String,
    val number: String,
)
