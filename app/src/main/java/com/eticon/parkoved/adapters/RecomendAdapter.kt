package com.eticon.parkoved.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eticon.parkoved.R
import com.eticon.parkoved.dataclasses.RecomendData

class RecomendAdapter (var items: List<RecomendData>) : RecyclerView.Adapter<RecomendAdapter.MainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)  = MainHolder(LayoutInflater.from(parent.context).inflate(
        R.layout.element_recomend, parent, false))
    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        holder.bind(items[position])
    }

    inner class MainHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val img = itemView.findViewById<ImageView>(R.id.img_rec)
        private val txt = itemView.findViewById<TextView>(R.id.txt_rec)

        fun bind(item: RecomendData) {
            img.setImageResource(item.image)
            txt.text = item.text

        }
    }

}