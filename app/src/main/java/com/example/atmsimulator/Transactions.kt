package com.example.atmsimulator

data class Transactions(
    val id: String,
    val receiptNo: String,
    val type: String,
    val timestamp: String,
    val transactionAmount: Double,
    val initialBalance: Double,
    val finalBalance: Double,
    // reference another data class
    val userId: Users,
    val recipientId: Users
)
