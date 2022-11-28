package com.example.monoplug.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.monoplug.R
import com.example.monoplug.model.HomeBlogs

class HomeBlogsAdapter(var list : List<HomeBlogs> , var clickListener : ClickListener3) : RecyclerView.Adapter<HomeBlogsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.home_blogs_design,parent,false)
        return MyViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      var itemPosition = list[position]
        holder.imgBlogs.setImageResource(itemPosition.imgBlogs)
        holder.tv1B.text=itemPosition.tv1B
        holder.tv2B.text=itemPosition.tv2B
        holder.tv3B.text=itemPosition.tv3B
        holder.cardViewHB.setOnClickListener {
            clickListener.onHomeBlogClick()
        }

    }

    override fun getItemCount(): Int {
       return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgBlogs : ImageView = itemView.findViewById(R.id.imgBlogs)
        var tv1B : TextView = itemView.findViewById(R.id.tv1B)
        var tv2B : TextView = itemView.findViewById(R.id.tv2B)
        var tv3B : TextView = itemView.findViewById(R.id.tv3B)
        var cardViewHB : CardView = itemView.findViewById(R.id.cardViewHB)

    }
}

interface ClickListener3 {
    fun onHomeBlogClick()
}
