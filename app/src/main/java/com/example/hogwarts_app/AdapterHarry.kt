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
        return ViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(filmsList[position], position)

        val color = colorsHP[position % colorsHP.size]
        holder.cardView.setCardBackgroundColor(color)
    }

    override fun getItemCount(): Int {
        return filmsList.size
    }

    class ViewHolder(itemView: View, private val context: Context) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.textView)
        val cardView: CardView = itemView.findViewById(R.id.cardView)

        fun bind(house: String, position: Int) {
            textView.text = house

            cardView.setOnClickListener {
                when (position) {
                    0 -> {
                        val intent1 = Intent(context, Gryffindor::class.java)
                        context.startActivity(intent1)
                    }

                    1 -> {
                        val intent1 = Intent(context, Hufflepuff::class.java)
                        context.startActivity(intent1)
                    }

                    2 -> {
                        val intent2 = Intent(context, Ravenclaw::class.java)
                        context.startActivity(intent2)
                    }

                    3 -> {
                        val intent3 = Intent(context, Slytherin::class.java)
                        context.startActivity(intent3)
                    }
                }
            }
        }
    }
}