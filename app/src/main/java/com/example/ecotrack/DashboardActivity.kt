package com.example.ecotrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val btnReportWaste = findViewById<Button>(R.id.btnReportWaste)
        val btnViewReports = findViewById<Button>(R.id.btnViewReports)
        val btnPickup = findViewById<Button>(R.id.btnPickup)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnPickup.setOnClickListener {
            startActivity(Intent(this, PickupActivity::class.java))
        }

        btnViewReports.setOnClickListener {
            startActivity(Intent(this, ViewReportsActivity::class.java))
        }

        btnReportWaste.setOnClickListener {
            startActivity(Intent(this, ReportWasteActivity::class.java))
        }

        btnLogout.setOnClickListener {

            FirebaseAuth.getInstance().signOut()

            startActivity(Intent(this, LoginActivity::class.java))
            finish()

        }

    }
}