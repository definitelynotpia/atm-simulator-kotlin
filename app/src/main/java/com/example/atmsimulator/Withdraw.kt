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

class Withdraw : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_withdraw)

        // Get user input
        val userWithdrawAmount = findViewById<EditText>(R.id.withdrawAmount)

        // Get values from previous activity
        val balance = intent.getDoubleExtra("updatedBalance", 100000.0)
        val intent = Intent(this, Dashboard::class.java)

        // Set balance display to current balance value
        val balanceString = balance.toString()
        val balanceDisplay = findViewById<TextView>(R.id.accountBalance)
        balanceDisplay.text = balanceString

        // Make variables for delete, submit and back to dashboard buttons
        val submitButton = findViewById<TextView>(R.id.withdrawSubmit)
        val backButton = findViewById<TextView>(R.id.withdrawCancel)

        // Get quick withdraw buttons
        val withdrawButton1 = findViewById<TextView>(R.id.quickDeposit1)
        val withdrawButton2 = findViewById<TextView>(R.id.quickDeposit2)
        val withdrawButton3 = findViewById<TextView>(R.id.quickDeposit3)
        val withdrawButton4 = findViewById<TextView>(R.id.quickDeposit4)
        val withdrawButton5 = findViewById<TextView>(R.id.quickDeposit5)
        val withdrawButton6 = findViewById<TextView>(R.id.quickDeposit6)

        // Return to dashboard
        backButton.setOnClickListener {
            startActivity(Intent(this, Dashboard::class.java), null)
        }

        fun submit() {
            val withdrawAmountSubmitted = userWithdrawAmount.text.toString()

            // Check if withdraw amount is not filled
            if (withdrawAmountSubmitted == "") {
                Toast.makeText(
                    this, "Please insert amount first", Toast.LENGTH_SHORT
                ).show()
            }// Shows alert dialog once withdraw amount is submitted
            else {
                // add withdrawed amount to balance
                val newBalance = balance - withdrawAmountSubmitted.toDouble()
                // generate random UUID
                val referenceNo = UUID.randomUUID().mostSignificantBits.toString(36).substring(1)
                // get current timestamp
                val transactionTimestamp = LocalDateTime.now().format(
                    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a").withZone(ZoneOffset.UTC)
                )

                // send new balance value to Dashboard
                intent.putExtra("transactionType", "WITHDRAW")
                intent.putExtra("transactionTimestamp", transactionTimestamp)
                intent.putExtra("transactionReference", referenceNo)
                intent.putExtra("initialBalance", balance)
                intent.putExtra("updatedBalance", newBalance)
                startActivity(intent)
            }
        }

        withdrawButton1.setOnClickListener {
            userWithdrawAmount.setText(getString(R.string.quickDeposit1))
            submit()
        }
        withdrawButton2.setOnClickListener {
            userWithdrawAmount.setText(getString(R.string.quickDeposit2))
            submit()
        }
        withdrawButton3.setOnClickListener {
            userWithdrawAmount.setText(getString(R.string.quickDeposit3))
            submit()
        }
        withdrawButton4.setOnClickListener {
            userWithdrawAmount.setText(getString(R.string.quickDeposit4))
            submit()
        }
        withdrawButton5.setOnClickListener {
            userWithdrawAmount.setText(getString(R.string.quickDeposit5))
            submit()
        }
        withdrawButton6.setOnClickListener {
            userWithdrawAmount.setText(getString(R.string.quickDeposit6))
            submit()
        }

        // Set on click listener for submit button
        submitButton.setOnClickListener { submit() }

        // Set on click listener for back to dashboard button
        backButton.setOnClickListener {
            intent.putExtra("transactionType", "none")
            intent.putExtra("transactionTimestamp", "")
            intent.putExtra("transactionReference", "")
            intent.putExtra("initialBalance", balance)
            intent.putExtra("updatedBalance", balance)
            startActivity(intent)
        }
    }
}