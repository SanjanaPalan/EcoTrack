package com.example.ecotrack

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class ReportWasteActivity : AppCompatActivity() {

    private val database = FirebaseDatabase.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_report_waste)

        val etWasteType = findViewById<EditText>(R.id.etWasteType)
        val etLocation = findViewById<EditText>(R.id.etLocation)
        val etDescription = findViewById<EditText>(R.id.etDescription)

        val btnSubmitReport = findViewById<Button>(R.id.btnSubmitReport)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }

        btnSubmitReport.setOnClickListener {

            val wasteType = etWasteType.text.toString().trim()
            val location = etLocation.text.toString().trim()
            val description = etDescription.text.toString().trim()

            if (wasteType.isEmpty() || location.isEmpty() || description.isEmpty()) {

                Toast.makeText(this, "Fill all fields", Toast.LENGTH_SHORT).show()

            } else {

                val report = hashMapOf(
                    "wasteType" to wasteType,
                    "location" to location,
                    "description" to description,
                    "status" to "Pending"
                )
                database.reference
                    .child("waste_reports")
                    .push()
                    .setValue(report)
                    .addOnSuccessListener {

                        Toast.makeText(
                            this,
                            "Report Submitted",
                            Toast.LENGTH_SHORT
                        ).show()

                        etWasteType.text.clear()
                        etLocation.text.clear()
                        etDescription.text.clear()

                    }
                    .addOnFailureListener {

                        Toast.makeText(
                            this,
                            "Failed: ${it.message}",
                            Toast.LENGTH_LONG
                        ).show()

                    }

            }

        }

    }
}