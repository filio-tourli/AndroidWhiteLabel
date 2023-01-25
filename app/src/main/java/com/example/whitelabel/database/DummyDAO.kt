package com.example.whitelabel.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface DummyDAO {

    @Insert
    suspend fun insert(item: DummyEntity)

    @Update
    suspend fun update(item: DummyEntity)

    @Delete
    suspend fun delete(item: DummyEntity)

    @Query("SELECT * FROM 'DummyTable'")
    fun fetchAllItems(): Flow<List<DummyEntity>>
}

//crud methods