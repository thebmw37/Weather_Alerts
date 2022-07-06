package com.example.weatheralerts.userInterface

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.weatheralerts.R

class AlertAdapter(private val itemList: List<AlertItem>): RecyclerView.Adapter<AlertAdapter.RecyclerViewHolder>() {

    class RecyclerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var eventTextView: TextView = itemView.findViewById(R.id.eventTextView)
        var areaDescTextView: TextView = itemView.findViewById(R.id.areaDescTextView)
        var headlineTextView: TextView = itemView.findViewById(R.id.headlineTextView)
        var descriptionTextView: TextView = itemView.findViewById(R.id.descriptionTextView)
        var instructionTextView: TextView = itemView.findViewById(R.id.instructionTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.alert_box, parent, false)
        return RecyclerViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val currentItem = itemList[position]

        holder.eventTextView.text = currentItem.eventText
        holder.areaDescTextView.text = currentItem.areaDescText
        holder.headlineTextView.text = currentItem.headlineText
        holder.descriptionTextView.text = currentItem.descriptionText
        holder.instructionTextView.text = currentItem.instructionText
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}