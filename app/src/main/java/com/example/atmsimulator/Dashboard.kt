package com.example.atmsimulator

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Get values from previous activity
        val balance =
            intent.getDoubleExtra("updatedBalance", 100000.0)
        val balanceString = balance.toString()


        // Update balance display on dashboard
        val accountBalance = findViewById<TextView>(R.id.accountBalance)
        accountBalance.text = balanceString
        val referenceNo = intent.getIntExtra("newReference", 100)

        // Make Variables for Buttons
        val depositButton = findViewById<TextView>(R.id.moneyDeposit)
//        val transferButton = findViewById<TextView>(R.id.moneyTransfer)
//        val withdrawButton = findViewById<TextView>(R.id.moneyWithdraw)

        // Set On Click Listeners for all buttons

//        withdrawButton.setOnClickListener {
//            val intent = Intent(this, Withdraw::class.java)
//            intent.putExtra("updatedBalance", balance)
//            intent.putExtra("newReference", referenceNo)
//            startActivity(intent)
//        }

        depositButton.setOnClickListener {
            val intent = Intent(this, Deposit::class.java)
            intent.putExtra("updatedBalance", balance)
            intent.putExtra("newReference", referenceNo)
            startActivity(intent)
        }

//        transferButton.setOnClickListener {
//            val intent = Intent(this, Transfer::class.java)
//            intent.putExtra("updatedBalance", balance)
//            intent.putExtra("newReference", referenceNo)
//            startActivity(intent)
//        }
    }
}