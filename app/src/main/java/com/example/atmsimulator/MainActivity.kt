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

        // Backspace for PIN field
        fun deletePin(deleteType: Int) {
            when (deleteType) {
                0 -> {
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

                1 -> {
                    pinDigit4.text = getString(R.string.pinPlaceholder)
                    pinDigit3.text = getString(R.string.pinPlaceholder)
                    pinDigit2.text = getString(R.string.pinPlaceholder)
                    pinDigit1.text = getString(R.string.pinPlaceholder)
                }
            }
        }

        // Writes numbers in the PIN field
        fun writePin(pinNumber: String) {
            if (pinDigit1.text.toString() != "_") {
                if (pinDigit2.text.toString() != "_") {
                    if (pinDigit3.text.toString() != "_") {
                        if (pinDigit4.text.toString() == "_") pinDigit4.setText(pinNumber)
                    } else pinDigit3.setText(pinNumber)
                } else pinDigit2.setText(pinNumber)
            } else pinDigit1.setText(pinNumber)

            if (pinDigit4.text.toString() != "_") {
                // Concatenate PIN numbers into one string
                val newPin =
                    pinDigit1.text.toString() + pinDigit2.text.toString() + pinDigit3.text.toString() + pinDigit4.text.toString()

//                Toast.makeText(this, newPin, Toast.LENGTH_SHORT).show()

                // Make Alert Dialog
                val builder: AlertDialog.Builder = AlertDialog.Builder(this)

                // Check if there are more tries
                if (tries <= 1) {
                    builder.setMessage("You have 0 tries left! App will be closing now")
                        .setTitle("You have no tries left!").setPositiveButton("Exit App") { _, _ ->
                            moveTaskToBack(true)
                            exitProcess(-1)
                        }
                } else if (newPin == validPin1) {
                    builder.setMessage("You have successfully entered the correct pin number")
                        .setTitle("Entered PIN Success!").setPositiveButton("Continue") { _, _ ->
                            startActivity(Intent(this, Dashboard::class.java))
                        }
                } else if (newPin == validPin2) {
                    builder.setMessage("You have successfully entered the correct pin number")
                        .setTitle("Entered PIN Success!").setPositiveButton("Continue") { _, _ ->
                            startActivity(Intent(this, Dashboard::class.java))
                        }
                } else {
                    tries--
                    builder.setMessage("You have entered the wrong pin number")
                        .setTitle("Wrong PIN Entered").setPositiveButton("Try Again") { _, _ ->
                            deletePin(1)
                            Toast.makeText(
                                this, "You have $tries tries left", Toast.LENGTH_SHORT
                            ).show()
                        }
                }

                //Show Alert Dialog
                val dialog: AlertDialog = builder.create()
                dialog.setCanceledOnTouchOutside(false)
                dialog.show()
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

        // Set On Click Listener for Delete button
        buttonPinDelete.setOnClickListener { deletePin(0) }
    }
}
