package com.example.wavesoffood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        val next_btn=findViewById<Button>(R.id.NextButtonOnStart)

        next_btn.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent);

        }
    }
}