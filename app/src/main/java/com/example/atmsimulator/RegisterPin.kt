package com.example.atmsimulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.atmsimulator.data.User
import com.example.atmsimulator.data.UserViewModel

class RegisterPin : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_2)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]


        // Get values from register
        val firstnameValue = intent.getStringExtra("firstnameValue").toString()
        val lastnameValue = intent.getStringExtra("lastnameValue").toString()
        val emailAddressValue = intent.getStringExtra("emailAddressValue").toString()
        val phoneNumberValue = intent.getStringExtra("phoneNumberValue").toString()

        Toast.makeText(
            this,
            "Firstname: $firstnameValue, Lastname: $lastnameValue, Email: $emailAddressValue, Phone: $phoneNumberValue",
            Toast.LENGTH_SHORT
        ).show()

        // PIN digits
        val pinDigit1 = findViewById<TextView>(R.id.pinDigit1)
        val pinDigit2 = findViewById<TextView>(R.id.pinDigit2)
        val pinDigit3 = findViewById<TextView>(R.id.pinDigit3)
        val pinDigit4 = findViewById<TextView>(R.id.pinDigit4)
        // PIN misc buttons
        val buttonPinDelete = findViewById<TextView>(R.id.pinDelete)
        val registerCancel = findViewById<TextView>(R.id.registerCancel)
        val registerSubmit = findViewById<TextView>(R.id.registerSubmit)
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

        // store pin here
        var newPin = ""

        // Writes numbers in the PIN field
        fun writePin(pinNumber: String) {
            if (pinDigit1.text.toString() != "_") {
                if (pinDigit2.text.toString() != "_") {
                    if (pinDigit3.text.toString() != "_") {
                        if (pinDigit4.text.toString() == "_") pinDigit4.text = pinNumber
                    } else pinDigit3.text = pinNumber
                } else pinDigit2.text = pinNumber
            } else pinDigit1.text = pinNumber

            if (pinDigit4.text.toString() != "_") {
                // Concatenate PIN numbers into one string
                newPin =
                    pinDigit1.text.toString() + pinDigit2.text.toString() + pinDigit3.text.toString() + pinDigit4.text.toString()
            }
        }

        // Set On Click Listeners for all number buttons
        buttonPin1.setOnClickListener { writePin(getString(R.string.pin1)) }
        buttonPin0.setOnClickListener { writePin(getString(R.string.pin0)) }
        buttonPin2.setOnClickListener { writePin(getString(R.string.pin2)) }
        buttonPin3.setOnClickListener { writePin(getString(R.string.pin3)) }
        buttonPin4.setOnClickListener { writePin(getString(R.string.pin4)) }
        buttonPin5.setOnClickListener { writePin(getString(R.string.pin5)) }
        buttonPin6.setOnClickListener { writePin(getString(R.string.pin6)) }
        buttonPin7.setOnClickListener { writePin(getString(R.string.pin7)) }
        buttonPin8.setOnClickListener { writePin(getString(R.string.pin8)) }
        buttonPin9.setOnClickListener { writePin(getString(R.string.pin9)) }

        // delete entered PIN
        buttonPinDelete.setOnClickListener {
            val pinPlaceholder = getString(R.string.pinPlaceholder)
            if (pinDigit4.text.toString() != "_") {
                pinDigit4.text = pinPlaceholder
            } else if (pinDigit3.text.toString() != "_") {
                pinDigit3.text = pinPlaceholder
            } else if (pinDigit2.text.toString() != "_") {
                pinDigit2.text = pinPlaceholder
            } else if (pinDigit1.text.toString() != "_") {
                pinDigit1.text = pinPlaceholder
            }
        }

        registerSubmit.setOnClickListener {
            // create new User object
            val user =
                User(firstnameValue, lastnameValue, emailAddressValue, phoneNumberValue, newPin)
            if (::userViewModel.isInitialized && pinDigit4.text.toString() != "_") userViewModel.createUser(
                user
            )
            Toast.makeText(this, "Registered successfully", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, Login::class.java))
        }

        registerCancel.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}