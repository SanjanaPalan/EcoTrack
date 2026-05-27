package com.example.ecotrack

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class PickupActivity : AppCompatActivity() {

    private val database = FirebaseDatabase.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pickup)

        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }

        val etName = findViewById<EditText>(R.id.etName)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etWaste = findViewById<EditText>(R.id.etWaste)
        val etAddress = findViewById<EditText>(R.id.etAddress)

        val btnRequestPickup =
            findViewById<Button>(R.id.btnRequestPickup)

        btnRequestPickup.setOnClickListener {

            val name = etName.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val waste = etWaste.text.toString().trim()
            val address = etAddress.text.toString().trim()

            if (name.isEmpty() ||
                phone.isEmpty() ||
                waste.isEmpty() ||
                address.isEmpty()
            ) {

                Toast.makeText(
                    this,
                    "Fill all fields",
                    Toast.LENGTH_SHORT
                ).show()

            } else {

                val pickupRequest = hashMapOf(
                    "name" to name,
                    "phone" to phone,
                    "waste" to waste,
                    "address" to address
                )

                database.reference
                    .child("pickup_requests")
                    .push()
                    .setValue(pickupRequest)
                    .addOnSuccessListener {

                        Toast.makeText(
                            this,
                            "Pickup Requested",
                            Toast.LENGTH_SHORT
                        ).show()

                        etName.text.clear()
                        etPhone.text.clear()
                        etWaste.text.clear()
                        etAddress.text.clear()

                    }

            }

        }

    }
}