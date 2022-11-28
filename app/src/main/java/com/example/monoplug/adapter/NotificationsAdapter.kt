package com.example.monoplug.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.monoplug.R
import com.example.monoplug.model.Notifications

class NotificationsAdapter(var list : List<Notifications> ) : RecyclerView.Adapter<NotificationsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.notification_design,parent,false)
        return MyViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var itemPosition = list[position]
        holder.tv1.text=itemPosition.tv1
        holder.tv2.text=itemPosition.tv2
        holder.tv3.text=itemPosition.tv3


    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv1 : TextView = itemView.findViewById(R.id.tv1)
        var tv2 : TextView = itemView.findViewById(R.id.tv2)
        var tv3 : TextView = itemView.findViewById(R.id.tv3)

    }
}

