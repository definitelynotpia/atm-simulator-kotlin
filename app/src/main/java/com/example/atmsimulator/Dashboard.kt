package com.example.atmsimulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Get values from previous activity
        val balance = intent.getIntExtra("newBalance", 10000)
        val balanceString = getString(R.string.currencyLabel) + balance.toString()
        val accountBalance = findViewById<TextView>(R.id.accountBalance)
        accountBalance.setText(balanceString)
        val referenceNo = intent.getIntExtra("newReference", 100)

        // Make Variables for Buttons
        val depositButton = findViewById<TextView>(R.id.moneyDeposit)
        val transferButton = findViewById<TextView>(R.id.moneyTransfer)
        val withdrawButton = findViewById<TextView>(R.id.moneyWithdraw)

        // Set On Click Listeners for all buttons
        withdrawButton.setOnClickListener {
            val intent = Intent(this, Withdraw::class.java)
            intent.putExtra("newBalance", balance)
            intent.putExtra("newReference", referenceNo)
            startActivity(intent)
        }

        depositButton.setOnClickListener {
            val intent = Intent(this, Deposit::class.java)
            intent.putExtra("newBalance", balance)
            intent.putExtra("newReference", referenceNo)
            startActivity(intent)
        }
        transferButton.setOnClickListener {
            val intent = Intent(this, Transfer::class.java)
            intent.putExtra("newBalance", balance)
            intent.putExtra("newReference", referenceNo)
            startActivity(intent)
        }
    }
}