package com.example.monoplug.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.monoplug.R
import com.example.monoplug.model.HomeStories

class HomeStoriesAdapter(val list : List<HomeStories>,val clickListener : ClickListener) : RecyclerView.Adapter<HomeStoriesAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.home_stories_design,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var itemPosition = list[position]
        holder.imgB.setImageResource(itemPosition.imgB)
        holder.imgS.setImageResource(itemPosition.imgS)
        holder.imgS2.setImageResource(itemPosition.imgS2)
        holder.imgS3.setImageResource(itemPosition.imgS3)
        holder.imgS4.setImageResource(itemPosition.imgS4)
        holder.textView.text= itemPosition.textView
        holder.cardView.setOnClickListener{
            clickListener.onHomeStoryClick()
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgB : ImageView = itemView.findViewById(R.id.imgB)
        var imgS : ImageView = itemView.findViewById(R.id.imgS)
        var imgS2 : ImageView = itemView.findViewById(R.id.imgS2)
        var imgS3 : ImageView = itemView.findViewById(R.id.imgS3)
        var imgS4 : ImageView = itemView.findViewById(R.id.imgS4)
        var textView : TextView = itemView.findViewById(R.id.textView)
        var cardView : CardView= itemView.findViewById(R.id.cardView)
    }
    interface ClickListener{
        fun onHomeStoryClick()
    }
}