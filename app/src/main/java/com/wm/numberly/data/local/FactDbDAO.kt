package com.wm.numberly.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface FactDbDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFact(fact: FactListingEntity)

    @Query("SELECT * FROM FactsTable ORDER BY id DESC ")
    suspend fun getAllFacts(): MutableList<FactListingEntity>


    @Query("DELETE  FROM FactsTable")
    suspend fun clearNote()

}