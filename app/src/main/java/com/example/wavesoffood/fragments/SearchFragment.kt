package com.example.wavesoffood.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.MenuAdapter

import android.widget.SearchView;


class SearchFragment : Fragment() {

    private lateinit var adapter : MenuAdapter
    private val OriginalmenuFoodName = listOf( "Burger", "sandwich", "momo", "item", "sandwich", "momo")
    private val OriginalmenuItemPtice = listOf("$5", "$6", "$8", "$9","$10","$10")
    private val OriginalmenuImage = listOf(R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5,R.drawable.food2)




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val  rootView= inflater.inflate(R.layout.fragment_search, container, false)
        adapter = MenuAdapter(ArrayList(OriginalmenuFoodName),ArrayList(OriginalmenuItemPtice),ArrayList(OriginalmenuImage))

        val menuoriRecyclerView = rootView.findViewById<RecyclerView>(R.id.menuRecyclerView)
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        menuoriRecyclerView.layoutManager = layoutManager
        menuoriRecyclerView.adapter = adapter



        setUpsearchView(rootView)

        showAllMenu()
        return rootView
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        filteredMenuFoodName.addAll(OriginalmenuFoodName)
        filteredMenuItemPrice.addAll(OriginalmenuItemPtice)
        filteredMenuImage.addAll(OriginalmenuImage)
    }

    private fun setUpsearchView(rootView:View) {
        val searchView = rootView.findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterMenuItems(query.toString())
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                filterMenuItems(newText)
                return true
            }


        })
    }


    private fun filterMenuItems(query: String) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        OriginalmenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query, ignoreCase = true)) {
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(OriginalmenuItemPtice[index])
                filteredMenuImage.add(OriginalmenuImage[index])
            }
        }

        // Notify the adapter about the changes in the filtered lists
        adapter.notifyDataSetChanged()
    }


    companion object {

    }
}