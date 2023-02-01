package com.example.whitelabel.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DummyEntity::class], version = 1)

abstract class DummyDatabase : RoomDatabase() {

    abstract fun dummyDao(): DummyDAO
}