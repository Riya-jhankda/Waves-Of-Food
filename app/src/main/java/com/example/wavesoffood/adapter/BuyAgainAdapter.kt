package com.example.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.R

class BuyAgainAdapter(
    private val buyAgainItems: MutableList<String>,
    private val buyAgainPrice: MutableList<String>,
    private var buyAgainImage: MutableList<Int>
) : RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.buy_again_item, parent, false)
        return BuyAgainViewHolder(itemView)
    }

    override fun getItemCount(): Int = buyAgainItems.size

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
        // Bind data to your ViewHolder here
        holder.bind(buyAgainItems[position],buyAgainPrice[position],buyAgainImage[position])
    }

    class BuyAgainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val foodName=itemView.findViewById<TextView>(R.id.buyAgainFoodName)
        val foodPrice=itemView.findViewById<TextView>(R.id.buyAgainPrice)
        val foodImage=itemView.findViewById<ImageView>(R.id.buyAgainImg)

        fun bind(foodname: String, foodprice: String, foodimage: Int) {

            foodName.text=foodname
            foodPrice.text=foodprice
            foodImage.setImageResource(foodimage)
        }
        // Define your ViewHolder here
    }
}
