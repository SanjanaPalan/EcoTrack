package com.example.ecotrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val btnReportWaste = findViewById<Button>(R.id.btnReportWaste)

        btnReportWaste.setOnClickListener {
            startActivity(Intent(this, ReportWasteActivity::class.java))
        }

    }
}