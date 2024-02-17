package com.example.wavesoffood.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.MenuAdapter
import com.example.wavesoffood.adapter.cardAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment:BottomSheetDialogFragment() {

    override  fun onCreate(savedInstances:Bundle?){
        super.onCreate(savedInstances)

    }
    //we just need to create a dummy data and recycler view mai data ko set krna hai

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_menu_bottom_sheet, container, false)

        val btnBack= rootView.findViewById<ImageButton>(R.id.btnBack)
        btnBack.setOnClickListener {
            dismiss()
        }

        //creating the raw data to being inserted into the manuAdapter
        val menuFoodName = listOf( "Burger", "sandwich", "momo", "item", "sandwich", "momo","Burger", "sandwich", "momo", "item", "sandwich", "momo")
        val menuItemPtice = listOf("$5", "$6", "$8", "$9","$10","$10","$5", "$6", "$8", "$9","$10","$10")
        val menuImage = listOf(R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,R.drawable.food2,R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,R.drawable.food2)

        //creating an adapter that acts like a bridge between the rawdata and the recycler view of menuBottomSheetFragmnet layout
        val adapter= MenuAdapter(ArrayList(menuFoodName),ArrayList(menuItemPtice),ArrayList(menuImage),requireContext())

        //refernce for the recycler view of menu
        val menuRecyclerView = rootView.findViewById<RecyclerView>(R.id.menuRecyclerView)
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        menuRecyclerView.layoutManager = layoutManager
        menuRecyclerView.adapter = adapter

        return rootView
    }
}