package com.example.monoplug.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.monoplug.R
import com.example.monoplug.model.MyRooms

class MyRoomsAdapter(var list : List<MyRooms> , var btnViewUserClick : BtnViewUserClick) : RecyclerView.Adapter<MyRoomsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.my_rooms_design,parent,false)
        return MyViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var itemPosition = list[position]
        holder.tv1.text=itemPosition.tv1
        holder.tv2.text=itemPosition.tv2

        holder.btnViewUsers.setOnClickListener{
            btnViewUserClick.onClick()
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv1 : TextView = itemView.findViewById(R.id.tv1)
        var tv2 : TextView = itemView.findViewById(R.id.tv2)
        var btnViewUsers : Button = itemView.findViewById(R.id.btnViewUsers)
        var btnDeleteRoom : Button = itemView.findViewById(R.id.btnDeleteRoom)

    }
    interface BtnViewUserClick{
        fun onClick()
    }
}

