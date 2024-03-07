package com.example.atmsimulator

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class Register : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val db = Firebase.database("https://android-kotlin-backend-default-rtdb.asia-southeast1.firebasedatabase.app")
        val dbRef = db.getReference("Users")

//        dbRef = FirebaseDatabase
//            .getInstance("https://android-kotlin-backend-default-rtdb.asia-southeast1.firebasedatabase.app")
//            .getReference("Users")
//        dbRef = Firebase
//            .database("https://android-kotlin-backend-default-rtdb.asia-southeast1.firebasedatabase.app")
//            .reference

        val firstname = findViewById<android.widget.EditText>(R.id.firstname)
        val lastname = findViewById<android.widget.EditText>(R.id.lastname)
        val emailAddress = findViewById<android.widget.EditText>(R.id.emailAddress)
        val phoneNumber = findViewById<android.widget.EditText>(R.id.phoneNumber)

        val registerSubmit = findViewById<TextView>(R.id.registerSubmit)
        val registerCancel = findViewById<TextView>(R.id.registerCancel)

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
            }

            // generate primary key
            val userId = dbRef.push().key!!
            // create new User object
            val user = User(
                userId,
                firstnameValue,
                lastnameValue,
                emailAddressValue,
                phoneNumberValue,
                "",
                0.0
            )

            Toast.makeText(this, "$user", Toast.LENGTH_SHORT).show()

            // insert user object into database with key=userId
            dbRef.child("Users").child(userId).setValue("test")
                .addOnCompleteListener {
                    Toast.makeText(this, "User added successfully", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { err ->
                    Toast.makeText(this, "Error: ${err.message}", Toast.LENGTH_SHORT).show()
                }
        }

        // return to home page
        registerCancel.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}