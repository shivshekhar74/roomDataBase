package com.example.myapplication.room
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "outletData")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val age: Int
)
