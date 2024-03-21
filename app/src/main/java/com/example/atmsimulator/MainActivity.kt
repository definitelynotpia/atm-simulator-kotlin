package com.example.atmsimulator

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.atmsimulator.data.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize number of users
        var userCount = intent.getIntExtra("userCount", 0)

        val loginButton = findViewById<TextView>(R.id.loginButton)
        val registerButton = findViewById<TextView>(R.id.registerButton)

        fun initUsers(intent: Intent) {
            val user1 =
                User(1, "Maria", "Clara", "mclara@mail.com", "09123456789", "1234", 264980.0)
            val user2 =
                User(2, "John", "Smith", "johnsmith@mail.com", "09987654321", "5678", 18507.5)
            // initialize users
            if (userCount == 0) {
                userCount++
                intent.putExtra("userId$userCount", userCount)
                intent.putExtra("firstname$userCount", user1.firstname)
                intent.putExtra("lastname$userCount", user1.lastname)
                intent.putExtra("emailAddress$userCount", user1.email)
                intent.putExtra("phoneNumber$userCount", user1.phone)
                intent.putExtra("pin$userCount", user1.pin)
                intent.putExtra("updatedBalance$userCount", user1.updatedBalance)
                userCount++
                intent.putExtra("userId$userCount", userCount)
                intent.putExtra("firstname$userCount", user2.firstname)
                intent.putExtra("lastname$userCount", user2.lastname)
                intent.putExtra("emailAddress$userCount", user2.email)
                intent.putExtra("phoneNumber$userCount", user2.phone)
                intent.putExtra("pin$userCount", user2.pin)
                intent.putExtra("updatedBalance$userCount", user2.updatedBalance)
                intent.putExtra("userCount", userCount)
            }
        }

        // if user has account, go to Login
        loginButton.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            initUsers(intent)
            // go to login
            startActivity(intent)
        }
        // else, go to register
        registerButton.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            // initialize users
            initUsers(intent)
            // go to registration
            startActivity(intent)
        }
    }
}