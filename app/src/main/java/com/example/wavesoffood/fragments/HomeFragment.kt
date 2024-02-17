package com.example.wavesoffood.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.PopularAdapter
import java.text.FieldPosition

class HomeFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //this code line is used to inflate all the other layouts so they can be used in this fragment
        val rootView = inflater.inflate(R.layout.fragment_home, container, false)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))
        imageList.add(SlideModel(R.drawable.banner1, ScaleTypes.FIT))

        val imageSlider = rootView.findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)

        val viewMenubtn= rootView.findViewById<TextView>(R.id.menuuu)
        viewMenubtn.setOnClickListener{
            val bottomSheetDialog=MenuBottomSheetFragment()
            bottomSheetDialog.show(parentFragmentManager,"Test")

        }

        imageSlider.setItemClickListener(object:ItemClickListener{
            override  fun doubleClick(position: Int){
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {
               val itemPosition=imageList[position]
                val itemMessage="Selected Image $position"
                Toast.makeText(requireContext(),itemMessage,Toast.LENGTH_SHORT).show()
            }
        })

        val foodName=listOf("Burger","Sandwitch","Cofee","Momo","Tikki")
        val iprice=listOf("$5","$7","$9","$11","$13")
        val popularfoodImages= listOf(R.drawable.food1,R.drawable.food2,R.drawable.food3,R.drawable.food4,R.drawable.food5)

        //now wherever we wanted to use any other layout , we simply find its id using findViewById and then use that accordingly.
        val popularRecyclerView = rootView.findViewById<RecyclerView>(R.id.popularRecyclerView)
        val layoutManager = LinearLayoutManager(requireContext())
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val adapter = PopularAdapter(foodName, popularfoodImages, iprice,requireContext())
        popularRecyclerView.layoutManager = layoutManager
        popularRecyclerView.adapter = adapter


        return rootView
    }




    companion object {

    }
}