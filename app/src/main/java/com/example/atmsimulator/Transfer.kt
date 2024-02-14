package com.example.atmsimulator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Transfer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer)

//        // Function to let the number button UI write in the deposit amount field
//        fun writeForm(num: Int, amount: EditText) {
//            val amountText = amount.text.toString() + num.toString()
//            amount.setText(amountText)
//        }
//
//        // Function to let the button UI delete(backspace) in the transfer amount field
//        fun reduceForm(amount: EditText) {
//            amount.setText(amount.text.toString().dropLast(1))
//        }
//
//        // Make variables for delete, submit and back to dashboard buttons
//        val deleteButton = findViewById<Button>(R.id.delete)
//        val submitButton = findViewById<Button>(R.id.submit)
//        val backButton = findViewById<Button>(R.id.back)
//
//        // Get values from previous activity
//        var balance = intent.getIntExtra("newBalance", 10000)
//        val balanceText = findViewById<TextView>(R.id.balance)
//        var referenceNo = intent.getIntExtra("newReference", 100)
//
//        // Change Balance Amount Text based on current balance
//        val newBalanceText = "$balance PHP"
//        balanceText.setText(newBalanceText)
//
//        // NumPad UI
//        val buttonNum0 = findViewById<Button>(R.id.buttonNum0)
//        val buttonNum1 = findViewById<Button>(R.id.buttonNum1)
//        val buttonNum2 = findViewById<Button>(R.id.buttonNum2)
//        val buttonNum3 = findViewById<Button>(R.id.buttonNum3)
//        val buttonNum4 = findViewById<Button>(R.id.buttonNum4)
//        val buttonNum5 = findViewById<Button>(R.id.buttonNum5)
//        val buttonNum6 = findViewById<Button>(R.id.buttonNum6)
//        val buttonNum7 = findViewById<Button>(R.id.buttonNum7)
//        val buttonNum8 = findViewById<Button>(R.id.buttonNum8)
//        val buttonNum9 = findViewById<Button>(R.id.buttonNum9)
//
//        // Make variables for fields
//        val transferForm = findViewById<EditText>(R.id.editTextNumber)
//        val accountForm = findViewById<EditText>(R.id.accountNo)
//        val receiverForm = findViewById<EditText>(R.id.receiver)
//        transferForm.setShowSoftInputOnFocus(false)
//        transferForm.inputType = InputType.TYPE_NULL
//
//        // Set On Click Listeners for all number buttons
//        buttonNum0.setOnClickListener { writeForm(0, transferForm) }
//        buttonNum1.setOnClickListener { writeForm(1, transferForm) }
//        buttonNum2.setOnClickListener { writeForm(2, transferForm) }
//        buttonNum3.setOnClickListener { writeForm(3, transferForm) }
//        buttonNum4.setOnClickListener { writeForm(4, transferForm) }
//        buttonNum5.setOnClickListener { writeForm(5, transferForm) }
//        buttonNum6.setOnClickListener { writeForm(6, transferForm) }
//        buttonNum7.setOnClickListener { writeForm(7, transferForm) }
//        buttonNum8.setOnClickListener { writeForm(8, transferForm) }
//        buttonNum9.setOnClickListener { writeForm(9, transferForm) }
//
//        // Set On Click Listener for delete button
//        deleteButton.setOnClickListener { reduceForm(transferForm) }
//
//        // Set On Click Listener for Submit Button
//        submitButton.setOnClickListener {
//
//            // Make Alert Dialog
//            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
//
//            // Checks if Fields are all complete
//            if (accountForm.text.toString() == "") {
//                Toast.makeText(
//                    this,
//                    "Please insert account number of receiver",
//                    Toast.LENGTH_SHORT
//                ).show()
//            } else if (receiverForm.text.toString() == "") {
//                Toast.makeText(
//                    this,
//                    "Please insert a receiver",
//                    Toast.LENGTH_SHORT
//                ).show()
//            } else if (transferForm.text.toString() == "") {
//                Toast.makeText(
//                    this,
//                    "Please insert amount first",
//                    Toast.LENGTH_SHORT
//                ).show()
//            } // If All Fields Are Complete, Show Alert Dialog
//            else {
//                builder
//                    .setMessage(
//                        "Reference No.: " + referenceNo +
//                                "\nDate: " + SimpleDateFormat(
//                            "yyyy-MM-dd HH:mm:ss",
//                            Locale.getDefault()
//                        ).format(
//                            Calendar.getInstance().time
//                        ) +
//                                "\nAccount No.: " + accountForm.text.toString() +
//                                "\nName: " + receiverForm.text.toString() +
//                                "\nAmount: " + transferForm.text.toString() + " PHP"
//                    )
//
//                    .setTitle("Confirm Details Before Continuing!")
//                    .setPositiveButton("Continue") { _, _ ->
//                        balance -= transferForm.text.toString().toInt()
//                        val newBalanceString = "$balance PHP"
//                        balanceText.setText(newBalanceString)
//
//                        Toast.makeText(
//                            this,
//                            "Your new balance is:$balance PHP",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                        referenceNo += 1
//                        transferForm.setText("")
//                        accountForm.setText("")
//                        receiverForm.setText("")
//                    }
//                    .setNegativeButton("Cancel") { _, _ ->
//                    }
//                val dialog: AlertDialog = builder.create()
//                dialog.show()
//            }
//        }
//
//        // Go Back to Dashboard
//        backButton.setOnClickListener {
//            val intent = Intent(this, Dashboard::class.java)
//            intent.putExtra("newBalance", balance)
//            intent.putExtra("newReference", referenceNo)
//            startActivity(intent)
//        }
    }
}