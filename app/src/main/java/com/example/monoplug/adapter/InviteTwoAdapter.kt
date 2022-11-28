package com.example.monoplug.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.monoplug.R
import com.example.monoplug.model.InviteTwo

class InviteTwoAdapter(var list : List<InviteTwo> ) : RecyclerView.Adapter<InviteTwoAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.invite_two_design,parent,false)
        return MyViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var itemPosition = list[position]
        holder.img.setImageResource(itemPosition.img)
        holder.tv1.text=itemPosition.tv1

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var img : ImageView =itemView.findViewById(R.id.img)
        var tv1 : TextView = itemView.findViewById(R.id.tv1)

    }
}

