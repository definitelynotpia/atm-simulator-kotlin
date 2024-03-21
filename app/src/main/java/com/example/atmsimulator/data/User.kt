package com.example.atmsimulator.data

data class User (
    val id: Int, // user id
    val firstname: String,
    val lastname: String,
    val email: String,
    val phone: String,
    val pin: String, // PIN password
    val updatedBalance: Double? = 0.0,
    val initialBalance: Double? = 0.0,
)