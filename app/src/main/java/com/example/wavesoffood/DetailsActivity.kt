package com.example.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val foodName = intent.getStringExtra("MenuItemName")
        val foodImage = intent.getIntExtra("MenuItemImage", 0)

        val detailFoodName = findViewById<TextView>(R.id.detailFoodName)
        val detailFoodImage = findViewById<ImageView>(R.id.detailFoodImg)

        val btnback=findViewById<ImageButton>(R.id.imageButton)
        btnback.setOnClickListener {
            finish()
        }


    }
}