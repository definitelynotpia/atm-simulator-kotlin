package com.example.atmsimulator

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Tries
        var tries = 4
        // Valid pin
        val validPin1 = "1234"
        val validPin2 = "5678"

        val pinDigit1 = findViewById<TextView>(R.id.pinDigit1)
        val pinDigit2 = findViewById<TextView>(R.id.pinDigit2)
        val pinDigit3 = findViewById<TextView>(R.id.pinDigit3)
        val pinDigit4 = findViewById<TextView>(R.id.pinDigit4)

        // PIN misc buttons
        val buttonPinDelete = findViewById<TextView>(R.id.pinDelete)

        // PIN number buttons
        val buttonPin1 = findViewById<TextView>(R.id.pin1)
        val buttonPin4 = findViewById<TextView>(R.id.pin4)
        val buttonPin7 = findViewById<TextView>(R.id.pin7)
        val buttonPin2 = findViewById<TextView>(R.id.pin2)
        val buttonPin5 = findViewById<TextView>(R.id.pin5)
        val buttonPin8 = findViewById<TextView>(R.id.pin8)
        val buttonPin0 = findViewById<TextView>(R.id.pin0)
        val buttonPin3 = findViewById<TextView>(R.id.pin3)
        val buttonPin6 = findViewById<TextView>(R.id.pin6)
        val buttonPin9 = findViewById<TextView>(R.id.pin9)

        // Writes numbers in the PIN field
        fun writePin(pinNumber: String) {
            if (pinDigit1.text.toString() != "_") {
                if (pinDigit2.text.toString() != "_") {
                    if (pinDigit3.text.toString() != "_") {
                        if (pinDigit4.text.toString() == "_") pinDigit4.text = pinNumber
                        pinDigit3.text = pinNumber
                    }
                    pinDigit2.text = pinNumber
                }
                pinDigit1.text = pinNumber
            }
        }

        // Set On Click Listeners for all number buttons
        buttonPin0.setOnClickListener { writePin(getString(R.string.pin0)) }
        buttonPin1.setOnClickListener { writePin(getString(R.string.pin1)) }
        buttonPin2.setOnClickListener { writePin(getString(R.string.pin2)) }
        buttonPin3.setOnClickListener { writePin(getString(R.string.pin3)) }
        buttonPin4.setOnClickListener { writePin(getString(R.string.pin4)) }
        buttonPin5.setOnClickListener { writePin(getString(R.string.pin5)) }
        buttonPin6.setOnClickListener { writePin(getString(R.string.pin6)) }
        buttonPin7.setOnClickListener { writePin(getString(R.string.pin7)) }
        buttonPin8.setOnClickListener { writePin(getString(R.string.pin8)) }
        buttonPin9.setOnClickListener { writePin(getString(R.string.pin9)) }

        // Backspace for PIN field
        fun deletePin(
            pinDigit1: TextView,
            pinDigit2: TextView,
            pinDigit3: TextView,
            pinDigit4: TextView
        ) {
            if (pinDigit4.text.toString() != "_") {
                pinDigit4.text = getString(R.string.pinPlaceholder)
            } else if (pinDigit3.text.toString() != "_") {
                pinDigit3.text = getString(R.string.pinPlaceholder)
            } else if (pinDigit2.text.toString() != "_") {
                pinDigit2.text = getString(R.string.pinPlaceholder)
            } else if (pinDigit1.text.toString() != "_") {
                pinDigit1.text = getString(R.string.pinPlaceholder)
            }
        }

        // Set On Click Listener for Delete button
        buttonPinDelete.setOnClickListener {
            deletePin(pinDigit1, pinDigit2, pinDigit3, pinDigit4)
        }
    }
}
