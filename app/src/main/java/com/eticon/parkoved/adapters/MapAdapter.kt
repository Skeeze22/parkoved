package com.eticon.parkoved.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.eticon.parkoved.R

class MapAdapter (var items: List<String>) : RecyclerView.Adapter<MapAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)  = MainHolder(LayoutInflater.from(parent.context).inflate(R.layout.element_maps, parent, false))
    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val btn = itemView.findViewById<TextView>(R.id.btn_maps)

        fun bind(item: String) {
            btn.text = item

        }
    }

}
