package com.example.atmsimulator

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Withdraw : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_withdraw)

        // Function to let the number button UI write in the withdraw amount field
        fun writeForm(num: Int, amount: EditText) {
            val amountString = amount.text.toString() + num.toString()
            amount.setText(amountString)
        }

        // Function to let the button UI delete(backspace) in the withdraw amount field
        fun reduceForm(amount: EditText) {
            amount.setText(amount.text.toString().dropLast(1))
        }

        // Make variables for delete, submit and back to dashboard buttons
        val deleteButton = findViewById<Button>(R.id.delete)
        val submitButton = findViewById<Button>(R.id.submit)
        val backButton = findViewById<Button>(R.id.back)

        // Get values from previous activity
        var balance = intent.getIntExtra("newBalance", 10000)
        val balanceString = "$balance PHP"
        val balanceText = findViewById<TextView>(R.id.balance)
        balanceText.setText(balanceString)
        val referenceNo = intent.getIntExtra("newReference", 100)

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

        // Make withdraw field variable
        val withdrawForm = findViewById<EditText>(R.id.editTextNumber)
        withdrawForm.setShowSoftInputOnFocus(false)

        // Set on click listener for all number button
        buttonNum0.setOnClickListener { writeForm(0, withdrawForm) }
        buttonNum1.setOnClickListener { writeForm(1, withdrawForm) }
        buttonNum2.setOnClickListener { writeForm(2, withdrawForm) }
        buttonNum3.setOnClickListener { writeForm(3, withdrawForm) }
        buttonNum4.setOnClickListener { writeForm(4, withdrawForm) }
        buttonNum5.setOnClickListener { writeForm(5, withdrawForm) }
        buttonNum6.setOnClickListener { writeForm(6, withdrawForm) }
        buttonNum7.setOnClickListener { writeForm(7, withdrawForm) }
        buttonNum8.setOnClickListener { writeForm(8, withdrawForm) }
        buttonNum9.setOnClickListener { writeForm(9, withdrawForm) }

        // Set on click listener for delete button
        deleteButton.setOnClickListener { reduceForm(withdrawForm) }

        // Set on click listener for submit button
        submitButton.setOnClickListener {

            //Makes Alert Dialog
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)

            // Checks if withdraw amount is empty or higher than balance
            if (withdrawForm.text.toString() == "") {
                Toast.makeText(
                    this,
                    "Please insert amount first",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (withdrawForm.text.toString().toInt() > balance) {
                Toast.makeText(
                    this,
                    "Withdraw amount higher than balance",
                    Toast.LENGTH_SHORT
                ).show()
            }

            // Shows alert dialog once withdraw amount is submitted
            else {
                builder
                    .setMessage("You will withdraw: " + withdrawForm.text.toString() + " PHP")
                    .setTitle("Confirm Details Before Continuing!")
                    .setPositiveButton("Continue") { _, _ ->
                        val balanceTextContent = "$balance PHP"
                        balance -= withdrawForm.text.toString().toInt()
                        balanceText.setText(balanceTextContent)
                        withdrawForm.setText("")
                        Toast.makeText(
                            this,
                            "Your new balance is:$balance PHP",
                            Toast.LENGTH_SHORT
                        ).show()
                    }.setNegativeButton("Cancel") { _, _ ->
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
}