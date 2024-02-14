package com.example.wavesoffood.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wavesoffood.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment:BottomSheetDialogFragment() {

    override  fun onCreate(savedInstances:Bundle?){
        super.onCreate(savedInstances)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_menu_bottom_sheet, container, false)

        return rootView
    }
}