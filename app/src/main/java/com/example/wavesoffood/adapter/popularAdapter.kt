package com.example.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.R

class PopularAdapter(private val items: List<String>, private val image: List<Int>, private val price: List<String>) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.popular_item, parent, false)
        return PopularViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val itemprice = price[position]
        holder.bind(item, images, itemprice)
    }

    class PopularViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val foodNameTextView = itemView.findViewById<TextView>(R.id.food_name_popular)
         val foodImageView = itemView.findViewById<ImageView>(R.id.food_popular)
         val cpTextView = itemView.findViewById<TextView>(R.id.cp_popular)

        fun bind(item: String, images: Int, itemprice: String) {
            foodNameTextView.text = item
            foodImageView.setImageResource(images)
            cpTextView.text = itemprice
        }
    }
}
