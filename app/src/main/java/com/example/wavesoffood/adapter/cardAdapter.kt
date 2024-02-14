package com.example.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.R

class cardAdapter(private val cartItems:MutableList<String>, private val CartItemPrice: MutableList<String>, private var cartImage :MutableList<Int>): RecyclerView.Adapter<cardAdapter.cardViewHolder>() {
    private  val itemQuantities=IntArray(cartItems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardViewHolder {

        //LayoutInflater.from(parent.context)-> calling the layoutInflater from this parent class
        //false indicates that the inflated layout should not be immediately attached to the parent ViewGroup (RecyclerView).

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_item, parent, false)
        return cardViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    override fun onBindViewHolder(holder: cardViewHolder, position: Int) {
        holder.bind(position)
    }
    inner class cardViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView)  {

        val foodNameText = itemView.findViewById<TextView>(R.id.cartFoodname)
        val foodImageView = itemView.findViewById<ImageView>(R.id.cartimg)
        val cpTextView = itemView.findViewById<TextView>(R.id.cartPrice)
        val cartItemQnt= itemView.findViewById<TextView>(R.id.Cartitemqnt)
        fun bind(position: Int) {
            val quantity=itemQuantities[position]
            foodNameText.text=cartItems[position]
            foodImageView.setImageResource(cartImage[position])
            cpTextView.text=CartItemPrice[position]
            cartItemQnt.text=quantity.toString()

            //buttons
            val minus=itemView.findViewById<ImageButton>(R.id.minusbtn)
            val plus = itemView.findViewById<ImageView>(R.id.plusbtn)
            val dlt=itemView.findViewById<ImageButton>(R.id.trashbtn)

            minus.setOnClickListener {
               deceaseQuantity(position)
            }

            plus.setOnClickListener {
                increaseQuantity(position)
            }

            dlt.setOnClickListener {
                val itemPosistion=adapterPosition//it tell us the current position odf our cursor in the cart view
                if(itemPosistion!=RecyclerView.NO_POSITION){
                    deleteItem(position)
                }
            }


        }
        private fun increaseQuantity(position: Int) {
            if (itemQuantities[position] < 10) {
                itemQuantities[position]++
                cartItemQnt.text = itemQuantities[position].toString()
            }
        }
        private fun deceaseQuantity (position: Int) {
            if (itemQuantities [position]>1) {
                itemQuantities [position]--
                cartItemQnt.text = itemQuantities [position].toString()
            }
        }
        private fun deleteItem (position: Int) {
            cartItems.removeAt(position)
            cartImage.removeAt(position)
            CartItemPrice.removeAt(position)
            notifyItemRemoved (position)
            notifyItemRangeChanged (position,cartItems.size)
        }


    }
}