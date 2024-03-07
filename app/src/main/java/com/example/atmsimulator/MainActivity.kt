package com.example.atmsimulator

// firebase
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<TextView>(R.id.loginButton);
        val registerButton = findViewById<TextView>(R.id.registerButton);

        // if user has account, go to Login
        loginButton.setOnClickListener {
            startActivity(Intent(this, Login::class.java));
        }
        // else, go to register
        registerButton.setOnClickListener {
            startActivity(Intent(this, Register::class.java));
        }

    }
}