package com.example.atmsimulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Deposit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit)

        // Get user input
        val userDepositAmount = findViewById<EditText>(R.id.depositAmount)

        // Get values from previous activity
        var balance = intent.getDoubleExtra("updatedBalance", 100000.0)
        val balanceString = balance.toString()
        val balanceDisplay = findViewById<TextView>(R.id.accountBalance)
        balanceDisplay.text = balanceString
        val referenceNo = intent.getIntExtra("newReference", 100)

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
                    this,
                    "Please insert amount first",
                    Toast.LENGTH_SHORT
                ).show()
            }// Shows alert dialog once deposit amount is submitted
            else {
                // add deposited amount to balance
                balance += depositAmountSubmitted.toDouble()

                // send new balance value to Dashboard
                val intent = Intent(this, Dashboard::class.java)
                intent.putExtra("updatedBalance", balance)
                intent.putExtra("newReference", referenceNo)
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
            val intent = Intent(this, Dashboard::class.java)
            intent.putExtra("updatedBalance", balance)
            intent.putExtra("newReference", referenceNo)
            startActivity(intent)
        }
    }
}