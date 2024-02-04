package com.example.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView

class ChooseLocationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_location)

        val loactionList = arrayOf("Jaipur","Srinagar","Delhi","Hyderabad","Lucknow","Chennai","Cherapungi","Banaras");
        val adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,loactionList)
        val autocomplttextview=findViewById<AutoCompleteTextView>(R.id.Listoflocatoins)
        autocomplttextview.setAdapter(adapter)

    }
}