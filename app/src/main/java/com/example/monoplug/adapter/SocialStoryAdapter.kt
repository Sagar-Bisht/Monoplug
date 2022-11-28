package com.example.monoplug.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.monoplug.R
import com.example.monoplug.model.SocialStory

class SocialStoryAdapter(var list : List<SocialStory> ) : RecyclerView.Adapter<SocialStoryAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.social_story_design, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var p = list[position]
        holder.imgStory.setImageResource(p.imgStory)
        holder.tvYourStory.text=p.tvYourStory
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgStory: ImageView = itemView.findViewById(R.id.imgStory)
        var tvYourStory: TextView = itemView.findViewById(R.id.tvYourStory)

    }
}