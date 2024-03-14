package com.example.atmsimulator.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TransactionInterface {

    @Query("SELECT * FROM transactions")
    fun getAllUsers(): List<Transaction>

    // search by transaction type
    @Query("SELECT * FROM transactions WHERE type IN (:types)")
    fun loadAllByType(types: IntArray): List<Transaction>

    // find receipt with reference number
    @Query("SELECT * FROM transactions WHERE id LIKE :id")
    fun findByRefNo(id: String): Transaction

    @Insert
    fun insertAll(vararg transactions: Transaction)

    @Delete
    fun delete(transactions: Transaction)
}