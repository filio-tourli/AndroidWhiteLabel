package com.example.whitelabel.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "DummyTable")
class DummyEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int
)