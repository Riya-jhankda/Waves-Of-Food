package com.example.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.R

class cardAdapter(private val cartItems:MutableList<String>, private val CartItemPrice: MutableList<String>, private var cartImage :MutableList<Int>): RecyclerView.Adapter<cardAdapter.cardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return cardAdapter.cardViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    override fun onBindViewHolder(holder: cardViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
    class cardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

    }
}