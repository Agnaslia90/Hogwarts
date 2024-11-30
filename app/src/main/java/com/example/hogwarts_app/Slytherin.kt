package com.example.hogwarts_app

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Slytherin: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.slytherin_activity)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        supportActionBar?.hide()
    }
}