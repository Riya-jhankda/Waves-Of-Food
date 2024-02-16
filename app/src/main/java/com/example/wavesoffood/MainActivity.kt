package com.example.wavesoffood

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.wavesoffood.fragments.NotificationBottomFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation_bar= findNavController(R.id.fragmentContainerView)
        val bottomnavview=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val bellbtn=findViewById<ImageView>(R.id.notificationBell)

        bellbtn.setOnClickListener {
            val bottomSheetDialog= NotificationBottomFragment()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }
        bottomnavview.setupWithNavController(navigation_bar)
    }
}