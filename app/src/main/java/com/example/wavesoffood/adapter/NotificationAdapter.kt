package com.example.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.R

class NotificationAdapter(private var notification : ArrayList<String>, private var notificationImage : ArrayList<Int> ): RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.notification_item,parent,false)
        return NotificationViewHolder(itemView)
    }

    override fun getItemCount(): Int =notification.size

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(position)
    }
    inner class NotificationViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val mssg=itemView.findViewById<TextView>(R.id.notification_textView)
        val pic = itemView.findViewById<ImageView>(R.id.notification_img)

        fun bind(position: Int) {
            mssg.text=notification[position]
            pic.setImageResource(notificationImage[position])

        }

    }

}