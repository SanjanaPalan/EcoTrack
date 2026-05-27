package com.example.ecotrack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ReportAdapter(private val reportList: ArrayList<WasteReport>) :
    RecyclerView.Adapter<ReportAdapter.ReportViewHolder>() {

    class ReportViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvWasteType: TextView = itemView.findViewById(R.id.tvWasteType)
        val tvLocation: TextView = itemView.findViewById(R.id.tvLocation)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
        val tvStatus: TextView = itemView.findViewById(R.id.tvStatus)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReportViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_report, parent, false)

        return ReportViewHolder(view)

    }

    override fun onBindViewHolder(holder: ReportViewHolder, position: Int) {

        val currentReport = reportList[position]

        holder.tvWasteType.text = currentReport.wasteType
        holder.tvLocation.text = currentReport.location
        holder.tvDescription.text = currentReport.description
        holder.tvStatus.text = "Status: ${currentReport.status}"

    }

    override fun getItemCount(): Int {
        return reportList.size
    }

}