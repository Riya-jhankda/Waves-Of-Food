package com.example.wavesoffood.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.wavesoffood.MainActivity
import com.example.wavesoffood.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class CongratsBottomSheet : BottomSheetDialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview =inflater.inflate(R.layout.fragment_congrats_bottom_sheet, container, false)

        val btn = rootview.findViewById<Button>(R.id.goHome)
        btn.setOnClickListener {
            val intent= Intent(requireContext(),MainActivity::class.java)
            startActivity(intent)
        }
        return rootview
    }

    companion object {

    }
}