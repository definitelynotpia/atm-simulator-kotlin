package com.example.atmsimulator.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val readAllData: LiveData<List<User>>
    private val repository: UserRepository

    init {
        val userInterface = UserDatabase.getDatabase(application).userInterface()
        repository = UserRepository(userInterface)
        readAllData = repository.getAllUsers
    }

    fun createUser(user: User) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.createUser(user)
        }
    }
}