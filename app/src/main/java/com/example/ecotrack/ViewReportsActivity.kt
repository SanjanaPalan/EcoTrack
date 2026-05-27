package com.example.ecotrack

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class ViewReportsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var reportList: ArrayList<WasteReport>
    private lateinit var adapter: ReportAdapter
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_reports)

        val btnBack = findViewById<Button>(R.id.btnBack)

        btnBack.setOnClickListener {
            finish()
        }

        recyclerView = findViewById(R.id.recyclerViewReports)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        reportList = arrayListOf()
        adapter = ReportAdapter(reportList)

        recyclerView.adapter = adapter

        databaseReference = FirebaseDatabase.getInstance()
            .getReference("waste_reports")

        databaseReference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                reportList.clear()

                for (reportSnapshot in snapshot.children) {

                    val report = reportSnapshot.getValue(WasteReport::class.java)

                    if (report != null) {
                        reportList.add(report)
                    }

                }

                adapter.notifyDataSetChanged()

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }
}