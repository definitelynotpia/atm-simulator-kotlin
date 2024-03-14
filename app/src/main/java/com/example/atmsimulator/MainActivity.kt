package com.example.atmsimulator

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.atmsimulator.data.User
import com.example.atmsimulator.data.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<TextView>(R.id.loginButton)
        val registerButton = findViewById<TextView>(R.id.registerButton)

        // if user has account, go to Login
        loginButton.setOnClickListener {
            startActivity(Intent(this, Login::class.java))
        }
        // else, go to register
        registerButton.setOnClickListener {
//            startActivity(Intent(this, RegisterPin::class.java))
            startActivity(Intent(this, Register::class.java))
        }

        // establish a database as the app only has an offline database
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        val user1 = User("Maria", "Clara", "mclara@mail.com", "09123456789", "1234", 264980.0)
        val user2 = User("John", "Smith", "johnsmith@mail.com", "09987654321", "5678", 18507.5)
        if (::userViewModel.isInitialized) {
            userViewModel.createUser(user1)
            userViewModel.createUser(user2)
        }

    }
}