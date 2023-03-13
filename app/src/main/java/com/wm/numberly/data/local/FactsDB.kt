package com.wm.numberly.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FactListingEntity::class],
    exportSchema = false,
    version = 1
)
abstract class FactsDB : RoomDatabase() {
    abstract val dao: FactDbDAO
}