package com.example.atmsimulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class Deposit : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deposit)

        // Make variables for delete, submit and back to dashboard buttons
        val deleteButton = findViewById<Button>(R.id.pinDelete)
        val submitButton = findViewById<Button>(R.id.pinSubmit)
        val backButton = findViewById<Button>(R.id.back)

        // Get values from previous activity
        var balance = intent.getIntExtra("newBalance", 10000)
        val balanceText = findViewById<TextView>(R.id.balance)
        balanceText.setText(balance.toString() + " PHP")
        var referenceNo = intent.getIntExtra("newReference", 100)

        // NumPad UI
        val buttonNum0 = findViewById<Button>(R.id.buttonNum0)
        val buttonNum1 = findViewById<Button>(R.id.buttonNum1)
        val buttonNum2 = findViewById<Button>(R.id.buttonNum2)
        val buttonNum3 = findViewById<Button>(R.id.buttonNum3)
        val buttonNum4 = findViewById<Button>(R.id.buttonNum4)
        val buttonNum5 = findViewById<Button>(R.id.buttonNum5)
        val buttonNum6 = findViewById<Button>(R.id.buttonNum6)
        val buttonNum7 = findViewById<Button>(R.id.buttonNum7)
        val buttonNum8 = findViewById<Button>(R.id.buttonNum8)
        val buttonNum9 = findViewById<Button>(R.id.buttonNum9)

        // Make variable for deposit amount value
        val depositForm = findViewById<EditText>(R.id.editTextNumber)
        depositForm.setShowSoftInputOnFocus(false)

        // Set On Click Listeners for all number buttons
        buttonNum0.setOnClickListener() { writeForm(0, depositForm) }
        buttonNum1.setOnClickListener() { writeForm(1, depositForm) }
        buttonNum2.setOnClickListener() { writeForm(2, depositForm) }
        buttonNum3.setOnClickListener() { writeForm(3, depositForm) }
        buttonNum4.setOnClickListener() { writeForm(4, depositForm) }
        buttonNum5.setOnClickListener() { writeForm(5, depositForm) }
        buttonNum6.setOnClickListener() { writeForm(6, depositForm) }
        buttonNum7.setOnClickListener() { writeForm(7, depositForm) }
        buttonNum8.setOnClickListener() { writeForm(8, depositForm) }
        buttonNum9.setOnClickListener() { writeForm(9, depositForm) }

        // Set on click listener for delete button
        deleteButton.setOnClickListener() { reduceForm(depositForm) }

        // Set on click listener for submit button
        submitButton.setOnClickListener {
            // Make Alert Dialog
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)

            // Check if deposit amount is not filled
            if (depositForm.text.toString() == "") {
                Toast.makeText(
                    this,
                    "Please insert amount first",
                    Toast.LENGTH_SHORT
                ).show()
            }// Shows alert dialog once deposit amount is submitted
            else {
                builder
                    .setMessage("You will deposit: " + depositForm.text.toString() + " PHP")
                    .setTitle("Confirm Details Before Continuing!")
                    .setPositiveButton("Continue") { dialog, which ->
                        balance = balance + depositForm.text.toString().toInt()
                        balanceText.setText(balance.toString() + " PHP")
                        depositForm.setText("")
                        Toast.makeText(
                            this,
                            "Your new balance is:" + balance + " PHP",
                            Toast.LENGTH_SHORT
                        ).show()
                    }.setNegativeButton("Cancel") { dialog, which ->
                    }
                val dialog: AlertDialog = builder.create()
                dialog.show()
            }
        }
        // Set on click listener for back to dashboard button
        backButton.setOnClickListener {
            val intent = Intent(this, Dashboard::class.java)
            intent.putExtra("newBalance", balance)
            intent.putExtra("newReference", referenceNo)
            startActivity(intent)
        }
    }

    // Function to let the number button UI write in the deposit amount field
    fun writeForm(num: Int, amount: EditText) {
        amount.setText(amount.text.toString() + num.toString())
    }

    // Function to let the button UI delete(backspace) in the deposit amount field
    fun reduceForm(amount: EditText) {
        amount.setText(amount.text.toString().dropLast(1))
    }
}