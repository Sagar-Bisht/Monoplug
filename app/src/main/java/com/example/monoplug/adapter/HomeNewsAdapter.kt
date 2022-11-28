package com.example.monoplug.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.monoplug.R
import com.example.monoplug.model.HomeNews

 class HomeNewsAdapter(var list : List<HomeNews> , var clickListener : ClickListener2) : RecyclerView.Adapter<HomeNewsAdapter.MyViewHolder>() {


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         var view = LayoutInflater.from(parent.context).inflate(R.layout.news_fragment_design,parent,false)
         return MyViewHolder(view)
     }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv1.text=list[position].tv1
        holder.tv2.text=list[position].tv2
         holder.cardView2.setOnClickListener {
             clickListener.onHomeNewsClick()
         }
     }

     override fun getItemCount(): Int {
        return list.size
     }

     class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

         var tv1 : TextView = itemView.findViewById(R.id.tv1)
         var tv2 : TextView = itemView.findViewById(R.id.tv2)
         var cardView2 : CardView = itemView.findViewById(R.id.cardView2)

     }
     interface ClickListener2{
         fun onHomeNewsClick()
     }
 }