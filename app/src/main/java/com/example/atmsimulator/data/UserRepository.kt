package com.example.atmsimulator.data

import androidx.lifecycle.LiveData

class UserRepository(private val userInterface: UserInterface) {
    val getAllUsers: LiveData<List<User>> = userInterface.getAllUsers()

    suspend fun createUser(user: User) {
        userInterface.createUser(user)
    }
}