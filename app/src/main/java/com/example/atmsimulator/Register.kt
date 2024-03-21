package com.example.atmsimulator

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // get user count
        var userCount = intent.getIntExtra("userCount", 0)
        // edittext data
        val firstname = findViewById<android.widget.EditText>(R.id.firstname)
        val lastname = findViewById<android.widget.EditText>(R.id.lastname)
        val emailAddress = findViewById<android.widget.EditText>(R.id.emailAddress)
        val phoneNumber = findViewById<android.widget.EditText>(R.id.phoneNumber)
        // buttons
        val registerSubmit = findViewById<TextView>(R.id.registerSubmit)
        val registerCancel = findViewById<TextView>(R.id.registerCancel)

        val intent = Intent(this, RegisterPin::class.java)

        // insert data to Firebase database
        registerSubmit.setOnClickListener {
            // get register values
            val firstnameValue = firstname.text.toString()
            val lastnameValue = lastname.text.toString()
            val emailAddressValue = emailAddress.text.toString()
            val phoneNumberValue = phoneNumber.text.toString()

            // make sure all fields have values
            if (firstnameValue.isEmpty() || lastnameValue.isEmpty() || emailAddressValue.isEmpty() || phoneNumberValue.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            } else {
                userCount++
                intent.putExtra("userId", userCount)
                intent.putExtra("firstnameValue", firstnameValue)
                intent.putExtra("lastnameValue", lastnameValue)
                intent.putExtra("emailAddressValue", emailAddressValue)
                intent.putExtra("phoneNumberValue", phoneNumberValue)
                Toast.makeText(this, "Proceeding to next step.", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

        // return to home page
        registerCancel.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}