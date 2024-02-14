package com.example.wavesoffood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.PopularAdapter
import com.example.wavesoffood.adapter.cardAdapter


class CartFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflating the layout file of cart_fragment to be converted into object code
        //and can be used to stode the data items
        val rootView = inflater.inflate(R.layout.fragment_cart, container, false)


        //creating the raw data to beinserted into the cardAdapter
        val cartFoodName = listOf( "Burger", "sandwich", "momo", "item", "sandwich", "momo")
        val cartItemPtice = listOf("$5", "$6", "$8", "$9","$10","$10")
        val cartImage = listOf(R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,R.drawable.food2)

        //creating an adapter that acts like a bridge between the rawdata and the recycler view of cart_fragmnet layout
        val adapter= cardAdapter(ArrayList(cartFoodName),ArrayList(cartItemPtice),ArrayList(cartImage))

        //refernce for the recycler view of cart
        val cartRecyclerView = rootView.findViewById<RecyclerView>(R.id.cardRecyclerView)
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        cartRecyclerView.layoutManager = layoutManager
        cartRecyclerView.adapter = adapter
        return rootView
    }

    companion object {

    }
}