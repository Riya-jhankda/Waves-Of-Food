package com.example.wavesoffood

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val txt_noacc=findViewById<TextView>(R.id.donthave_acc)

        txt_noacc.setOnClickListener{
            val intent = Intent(this,SignActivity::class.java)
            startActivity(intent)

        }

    }
}