package com.example.wavesoffood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.BuyAgainAdapter

class HistoryFragment : Fragment() {

    private lateinit var buyAgainAdapter: BuyAgainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview=inflater.inflate(R.layout.fragment_history, container, false)
        setupRecyclerView(rootview)
        return rootview
    }

    private fun setupRecyclerView(rootView:View) {

        val recycler = rootView.findViewById<RecyclerView>(R.id.buyAgainRecyclerView)

        val buyAgainFoodName = arrayListOf("Food 2", "Food 2", "Food 3")
        val buyAgainFoodPrice = arrayListOf("$10", "$0", "$30")
        val buyAgainFoodImage = arrayListOf(R.drawable.food1, R.drawable.food2, R.drawable.food5)
        buyAgainAdapter = BuyAgainAdapter (buyAgainFoodName, buyAgainFoodPrice, buyAgainFoodImage)
        recycler.adapter=buyAgainAdapter
        recycler.layoutManager=LinearLayoutManager(requireContext())

    }

    companion object {

    }
}