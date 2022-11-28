package com.example.monoplug.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.monoplug.R
import com.example.monoplug.model.ImageSlider

class VPagerAdapterForStoryDetails(var list : List<ImageSlider>) : RecyclerView.Adapter<VPagerAdapterForStoryDetails.MyViewHolder>() {


    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.image_slider,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var imgPosition  = list[position]
        holder.img.setImageResource(imgPosition.img)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var img : ImageView = itemView.findViewById(R.id.imgSlider)
    }
}
