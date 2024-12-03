package com.example.hogwarts_app

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class AdapterHarry(private val filmsList: List<String>, private val context: Context) :
    RecyclerView.Adapter<AdapterHarry.ViewHolder>() {

    val colorsHP = listOf(
        ContextCompat.getColor(context, R.color.griffindor),
        ContextCompat.getColor(context, R.color.hufflepuff),
        ContextCompat.getColor(context, R.color.ravenclaw),
        ContextCompat.getColor(context, R.color.slytherin)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.items_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(filmsList[position], position)

        val color = colorsHP[position % colorsHP.size]
        holder.cardView.setCardBackgroundColor(color)
    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

    class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val cardView: CardView = itemView.findViewById(R.id.cardView)

        fun bind(house: String, position: Int) {
            textView.text = house

            cardView.setOnClickListener {
                val intent = when (position) {
                    0 -> Intent(itemView.context, Gryffindor::class.java)
                    1 -> Intent(itemView.context, Hufflepuff::class.java)
                    2 -> Intent(itemView.context, Ravenclaw::class.java)
                    3 -> Intent(itemView.context, Slytherin::class.java)
                    else -> null
                }
                intent?.let { itemView.context.startActivity(it) }
            }
        }
    }
}