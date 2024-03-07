package com.example.atmsimulator

data class User(
    val id: String,
    val firstname: String,
    val lastname: String,
    val email: String,
    val phone: String,
    val pin: String,
    val currentBalance: Double
)