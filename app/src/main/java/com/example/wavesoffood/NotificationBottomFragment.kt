package com.example.wavesoffood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wavesoffood.adapter.NotificationAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class NotificationBottomFragment :BottomSheetDialogFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview=inflater.inflate(R.layout.fragment_notification_bottom, container, false)
        val notifications= listOf("Your order has been Canceled Successfully","Order has been taken by the driver","Congrats Your Order Placed")
        val notificationIndicators=listOf(R.drawable.sademoji,R.drawable.icon__6_,R.drawable.group_805)
        val adapter=NotificationAdapter(ArrayList(notifications), ArrayList(notificationIndicators))
        return rootview
    }

    companion object {
    }
}