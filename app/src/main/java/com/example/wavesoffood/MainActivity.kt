package com.example.wavesoffood

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.wavesoffood.fragments.NotificationBottomFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        if (loadTheme()) {
            setTheme(R.style.Theme_ThemeSwitcher_Dark);
        } else {
            setTheme(R.style.Theme_ThemeSwitcher_Light);
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation_bar= findNavController(R.id.fragmentContainerView)
        val bottomnavview=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val bellbtn=findViewById<ImageView>(R.id.notificationBell)

        //for switching themes
        val switch = findViewById<Switch>(R.id.theme_switch)

        switch.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                setTheme(R.style.Theme_ThemeSwitcher_Dark)
                saveTheme(true)
            } else {
                setTheme(R.style.Theme_ThemeSwitcher_Light)
                saveTheme(false)
            }
            recreate()
        }


        bellbtn.setOnClickListener {
            val bottomSheetDialog= NotificationBottomFragment()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }
        bottomnavview.setupWithNavController(navigation_bar)


    }

    private fun saveTheme(isDarkTheme: Boolean) {
        val preferences = getSharedPreferences("ThemeSwitcher", MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putBoolean("isDarkTheme", isDarkTheme)
        editor.apply()
    }

    private fun loadTheme(): Boolean {
        val preferences = getSharedPreferences("ThemeSwitcher", MODE_PRIVATE)
        return preferences.getBoolean("isDarkTheme", false)
    }

}