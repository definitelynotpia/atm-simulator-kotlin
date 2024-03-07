package com.example.atmsimulator

data class Transactions(
    val id: String, // referenceNo
    val userId: User, // references User data class
    val type: String,
    val timestamp: String,
    // transaction details
    val transactionAmount: Double,
    val startBalance: Double,
    val newBalance: Double,
    val recipientId: User? = null // can be null
)
