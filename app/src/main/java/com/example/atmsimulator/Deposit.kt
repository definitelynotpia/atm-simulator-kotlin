package com.example.atmsimulator

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.util.UUID

class Deposit : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit)

        // Get user input
        val userDepositAmount = findViewById<EditText>(R.id.depositAmount)

        // Get values from previous activity
        val currentUser = intent.getIntExtra("currentUser", 0)
        val balance = intent.getDoubleExtra("updatedBalance$currentUser", 100000.0)
        val intent = Intent(this, Dashboard::class.java)

        // Set balance display to current balance value
        val balanceString = balance.toString()
        val balanceDisplay = findViewById<TextView>(R.id.accountBalance)
        balanceDisplay.text = balanceString

        // Make variables for delete, submit and back to dashboard buttons
        val submitButton = findViewById<TextView>(R.id.depositSubmit)
        val backButton = findViewById<TextView>(R.id.depositCancel)

        // Get quick deposit buttons
        val depositButton1 = findViewById<TextView>(R.id.quickDeposit1)
        val depositButton2 = findViewById<TextView>(R.id.quickDeposit2)
        val depositButton3 = findViewById<TextView>(R.id.quickDeposit3)
        val depositButton4 = findViewById<TextView>(R.id.quickDeposit4)
        val depositButton5 = findViewById<TextView>(R.id.quickDeposit5)
        val depositButton6 = findViewById<TextView>(R.id.quickDeposit6)

        // Return to dashboard
        backButton.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java), null)
        }

        fun submit() {
            val depositAmountSubmitted = userDepositAmount.text.toString()

            // Check if deposit amount is not filled
            if (depositAmountSubmitted == "") {
                Toast.makeText(
                    this, "Please insert amount first", Toast.LENGTH_SHORT
                ).show()
            }// Shows alert dialog once deposit amount is submitted
            else {
                // add deposited amount to balance
                val newBalance = balance + depositAmountSubmitted.toDouble()
                // generate random UUID
                val referenceNo = UUID.randomUUID().mostSignificantBits.toString(36).substring(1)
                // get current timestamp
                val transactionTimestamp = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a").withZone(ZoneOffset.UTC)
                )

                // send new balance value to Dashboard
                intent.putExtra("transactionType", "DEPOSIT")
                intent.putExtra("transactionTimestamp", transactionTimestamp)
                intent.putExtra("transactionReference", referenceNo)
                intent.putExtra("initialBalance$currentUser", balance)
                intent.putExtra("transactionAmount", userDepositAmount.text.toString())
                intent.putExtra("updatedBalance$currentUser", newBalance)
                startActivity(intent)
            }
        }

        depositButton1.setOnClickListener {
            userDepositAmount.setText(getString(R.string.quickDeposit1))
            submit()
        }
        depositButton2.setOnClickListener {
            userDepositAmount.setText(getString(R.string.quickDeposit2))
            submit()
        }
        depositButton3.setOnClickListener {
            userDepositAmount.setText(getString(R.string.quickDeposit3))
            submit()
        }
        depositButton4.setOnClickListener {
            userDepositAmount.setText(getString(R.string.quickDeposit4))
            submit()
        }
        depositButton5.setOnClickListener {
            userDepositAmount.setText(getString(R.string.quickDeposit5))
            submit()
        }
        depositButton6.setOnClickListener {
            userDepositAmount.setText(getString(R.string.quickDeposit6))
            submit()
        }

        // Set on click listener for submit button
        submitButton.setOnClickListener { submit() }

        // Set on click listener for back to dashboard button
        backButton.setOnClickListener {
            intent.putExtra("transactionType", "none")
            intent.putExtra("transactionTimestamp", "")
            intent.putExtra("transactionReference", "")
            intent.putExtra("initialBalance$currentUser", balance)
            intent.putExtra("updatedBalance$currentUser", balance)
            startActivity(intent)
        }
    }
}