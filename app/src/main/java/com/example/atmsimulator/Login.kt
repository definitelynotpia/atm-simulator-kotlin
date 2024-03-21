package com.example.atmsimulator

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val registerButton = findViewById<TextView>(R.id.registerButton)
        val loginSubmit = findViewById<TextView>(R.id.loginSubmit)
        val loginCancel = findViewById<TextView>(R.id.loginCancel)

        val userCount = intent.getIntExtra("userCount", 0)

        val phoneNumber = findViewById<TextView>(R.id.phoneNumber)

        loginSubmit.setOnClickListener {
            val phoneNumberValue = phoneNumber.text.toString()

            if (phoneNumberValue.isEmpty()) {
                Toast.makeText(this, "Please enter your phone number", Toast.LENGTH_SHORT).show()
            }

            for (i in 0 until userCount) {
                val n = i + 1
                val userId = intent.getIntExtra("userId$n", userCount)
                val userPhoneNumber = intent.getStringExtra("phoneNumber$userId").toString()
                val userPin = intent.getStringExtra("pin$userId")
                val userUpdatedBalance = intent.getDoubleExtra("updatedBalance$userId", 0.0)
                if (userPhoneNumber == phoneNumberValue) {
                    val intent = Intent(this, LoginPin::class.java)
                    intent.putExtra("currentUser", userId)
                    intent.putExtra("pin$userId", userPin)
                    intent.putExtra("updatedBalance$userId", userUpdatedBalance)
                    startActivity(intent)
                    finish()
                }
            }
        }

        loginCancel.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        // register new bank account
        registerButton.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
    }
}