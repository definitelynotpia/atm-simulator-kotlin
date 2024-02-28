package com.example.atmsimulator

data class Users(
    val id: String,
    val pin: Int,
    val firstname: String,
    val lastname: String,
    val email: String,
    val mobile: String,
    val balance: Double
)
