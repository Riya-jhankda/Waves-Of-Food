package com.example.wavesoffood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.DialogFragment
import com.example.wavesoffood.fragments.CongratsBottomSheet
import com.google.android.material.bottomsheet.BottomSheetDialog

class PayOutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay_out)



        val btntocongrats=findViewById<Button>(R.id.placeorder)

        btntocongrats.setOnClickListener {
            val bottomSheetDialog = CongratsBottomSheet()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }

    }
}