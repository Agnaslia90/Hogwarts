package com.example.hogwarts_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()

        val recyclerView: RecyclerView = findViewById (R.id.recyclerView)

        val filmsHP = listOf("Gryffindor", "Hufflepuff", "Ravenclaw", "Slytherin")

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = AdapterHarry(filmsHP, this)

        val btnHouses: Button = findViewById(R.id.selectHouseBtn)
        val selectedHouse: TextView = findViewById(R.id.textViewSelected)

        btnHouses.setOnClickListener{
            val houseResult= filmsHP.random()
            selectedHouse.text = "Tu casa es: $houseResult"
            when (houseResult) {
                "Gryffindor" -> selectedHouse.setTextColor(getColor(R.color.griffindor))
                "Hufflepuff" -> selectedHouse.setTextColor(getColor(R.color.hufflepuff))
                "Ravenclaw" -> selectedHouse.setTextColor(getColor(R.color.ravenclaw))
                "Slytherin" -> selectedHouse.setTextColor(getColor(R.color.slytherin))
            }
        }
    }
}