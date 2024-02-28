package com.example.atmsimulator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Get values from previous activity
        val balance =
            intent.getDoubleExtra("updatedBalance", 100000.0)
        val initialBalance = intent.getDoubleExtra("initialBalance", 100000.0)
        val balanceString = balance.toString()
        val transactionTimestamp = intent.getStringExtra("transactionTimestamp")
        val transactionType = intent.getStringExtra("transactionType")
        val depositAmount = intent.getStringExtra("transactionAmount")
        val referenceNo = intent.getStringExtra("transactionReference")
        val transactionUUID = "Reference No. $referenceNo"

        // Update balance display on dashboard
        val accountBalance = findViewById<TextView>(R.id.accountBalance)
        accountBalance.text = balanceString

        val notificationDescription = findViewById<TextView>(R.id.notificationDescription)
        val notificationCard = findViewById<CardView>(R.id.notification)

        // If there is a transaction, display the notification (transaction receipt)
        if (balance != initialBalance) {
            // Update notification display on dashboard
            notificationCard.visibility = View.VISIBLE

            val transactionTypeLabel = findViewById<TextView>(R.id.transactionType)
            val transactionTimestampLabel = findViewById<TextView>(R.id.transactionTimestamp)
            val transactionUUIDLabel = findViewById<TextView>(R.id.transactionUUID)
            val initialBalanceAmount = findViewById<TextView>(R.id.initialBalanceAmount)
            val transactionAmount = findViewById<TextView>(R.id.transactionAmount)
            val newBalanceAmount = findViewById<TextView>(R.id.newBalanceAmount)
            // notification label
            notificationDescription.text = getString(R.string.notificationDescription)
            // receipt info
            transactionTypeLabel.text = transactionType.toString()
            transactionTimestampLabel.text = transactionTimestamp.toString()
            transactionUUIDLabel.text = transactionUUID
            // transaction info
            initialBalanceAmount.text = initialBalance.toString()
            transactionAmount.text = depositAmount.toString()
            newBalanceAmount.text = balanceString
        } else {
            // hide notification card
            notificationDescription.text = getString(R.string.notificationNoContent)
            notificationCard.visibility = View.GONE
        }

        // Make Variables for Buttons
        val depositButton = findViewById<TextView>(R.id.moneyDeposit)
        val transferButton = findViewById<TextView>(R.id.moneyTransfer)
        val withdrawButton = findViewById<TextView>(R.id.moneyWithdraw)

        // Set On Click Listeners for all buttons

        withdrawButton.setOnClickListener {
            val intent = Intent(this, Withdraw::class.java)
            intent.putExtra("updatedBalance", balance)
            startActivity(intent)
        }

        depositButton.setOnClickListener {
            Toast.makeText(
                this, balance.toString(), Toast.LENGTH_SHORT
            ).show()

            val intent = Intent(this, Deposit::class.java)
            intent.putExtra("updatedBalance", balance)
            startActivity(intent)
        }

        transferButton.setOnClickListener {
            val intent = Intent(this, Transfer::class.java)
            intent.putExtra("updatedBalance", balance)
            startActivity(intent)
        }
    }
}