package com.example.hogwarts_app

import android.os.Bundle
import android.view.View
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
    }
}