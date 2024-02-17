package com.example.wavesoffood.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.DetailsActivity
import com.example.wavesoffood.R

class PopularAdapter(private val items: List<String>, private val image: List<Int>, private val price: List<String>,private val requireContext:Context) : RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.popular_item, parent, false)
        return PopularViewHolder(itemview)
        //just for some general knowledge always remeber that there is an inbuilt function with the name itemView in kotlin
        //so remember if you are creating a varable so not make the varibale name similar to the function name
        //this will produce errro in the view holder
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = items[position]
        val images = image[position]
        val itemprice = price[position]
        holder.bind(item, images, itemprice)

        holder.itemView.setOnClickListener{
            val intent = Intent(requireContext, DetailsActivity::class.java)
            intent.putExtra("MenuItemName",item)
            intent.putExtra("MenuItemImage",images)
            requireContext.startActivity(intent)
        }
    }


    class PopularViewHolder(public val itemview: View) : RecyclerView.ViewHolder(itemview) {
         val foodNameTextView = itemview.findViewById<TextView>(R.id.menu_name)
         val foodImageView = itemview.findViewById<ImageView>(R.id.menu_img)
         val cpTextView = itemview.findViewById<TextView>(R.id.menu_price)

        fun bind(item: String, images: Int, itemprice: String) {
            foodNameTextView.text = item
            foodImageView.setImageResource(images)
            cpTextView.text = itemprice
        }
    }
}
