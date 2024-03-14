package com.example.atmsimulator.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserInterface {
    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE id IN (:ids)")
    fun loadAllByIds(ids: IntArray): List<User>

    @Query("SELECT * FROM users WHERE phone LIKE :phoneNumber LIMIT 1")
    fun findByPhoneNumber(phoneNumber: String): User

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun createUser(user: User)

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}