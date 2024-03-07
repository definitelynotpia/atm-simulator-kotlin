package com.example.atmsimulator

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val firebase: DatabaseReference = FirebaseDatabase.getInstance().getReference()

        val registerButton = findViewById<TextView>(R.id.registerButton)

        // register new bank account
        registerButton.setOnClickListener {
            startActivity(Intent(this, Register::class.java))
        }
    }
}