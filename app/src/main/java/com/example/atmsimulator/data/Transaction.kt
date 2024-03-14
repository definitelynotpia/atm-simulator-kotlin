package com.example.atmsimulator.data

import androidx.room.Entity

@Entity(tableName = "transactions")
data class Transaction(
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
