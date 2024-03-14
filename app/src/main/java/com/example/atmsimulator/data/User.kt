package com.example.atmsimulator.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class User(
    @ColumnInfo(name = "firstname") val firstname: String,
    @ColumnInfo(name = "lastname") val lastname: String,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "pin") val pin: String? = "0000",
    @ColumnInfo(name = "currentBalance") val currentBalance: Double? = 0.0,
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
)