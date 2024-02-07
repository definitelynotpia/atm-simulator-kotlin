package com.example.atmsimulator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    object Constants {
        // Tries
        const val TOTAL_TRIES_ALLOWED = 4

        // Valid pin
        const val VALID_PIN_1 = "1234"
        const val VALID_PIN_2 = "5678"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}