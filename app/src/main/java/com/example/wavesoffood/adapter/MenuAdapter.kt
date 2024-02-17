package com.example.wavesoffood.adapter

import android.content.Context
import android.content.DialogInterface.OnClickListener
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.DetailsActivity
import com.example.wavesoffood.R

class MenuAdapter(private val menuItems:MutableList<String>, private val menuItemPrice: MutableList<String>, private var menuImage :MutableList<Int>,private var recquireContext: Context): RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){

private val itemClickListener:OnClickListener ?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        return MenuViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return menuItems.size
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(position)
    }
    inner class MenuViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView)  {

        init {
            itemView.setOnClickListener{
                val position=adapterPosition
                if(position!=RecyclerView.NO_POSITION){
                    itemClickListener?.onItemClick(position)
                }
                val intent = Intent(recquireContext,DetailsActivity::class.java)
                intent.putExtra("MenuItemName",menuItems.get(position))
                intent.putExtra("MenuItemImage",menuImage.get(position))
                recquireContext.startActivity(intent)
            }
        }

        val foodNameText = itemView.findViewById<TextView>(R.id.menu_name)
        val foodImageView = itemView.findViewById<ImageView>(R.id.menu_img)
        val cpTextView = itemView.findViewById<TextView>(R.id.menu_price)
        fun bind(position: Int) {
            foodNameText.text=menuItems[position]
            foodImageView.setImageResource(menuImage[position])
            cpTextView.text=menuItemPrice[position]




        }

    }
    interface OnClickListener{
        fun onItemClick(position: Int)
    }
}

