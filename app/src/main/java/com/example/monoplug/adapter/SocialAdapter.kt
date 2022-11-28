package com.example.monoplug.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.monoplug.R
import com.example.monoplug.model.Social

class SocialAdapter(var list : List<Social> , var listerners : SocialInterface ) : RecyclerView.Adapter<SocialAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.social_fragment_design,parent,false)
        return MyViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var itemPosition = list[position]
        holder.sImg1.setImageResource(itemPosition.sImg1)
        holder.sImg1.setOnClickListener {
            listerners.onClickProfile()
        }
        holder.sImgB.setImageResource(itemPosition.sImgB)

        holder.sImgSm1.setImageResource(itemPosition.sImgSm1)
        holder.sImgSm1.setOnClickListener {
            listerners.onClick()
        }
        holder.sImgSm2.setImageResource(itemPosition.sImgSm2)
        holder.sImgSm3.setImageResource(itemPosition.sImgSm3)

        holder.stv1.text= itemPosition.stv1
        holder.stv2.text= itemPosition.stv2
        holder.stv3.text= itemPosition.stv3

        holder.clRoot.setOnClickListener{
            listerners.onClickPostDetails()
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var sImg1 : ImageView = itemView.findViewById(R.id.sImg1)
        var sImgB : ImageView = itemView.findViewById(R.id.sImgB)
        var sImgSm1 : ImageView = itemView.findViewById(R.id.sImgSm1)
        var sImgSm2 : ImageView = itemView.findViewById(R.id.sImgSm2)
        var sImgSm3 : ImageView = itemView.findViewById(R.id.sImgSm3)
        var stv1 : TextView = itemView.findViewById(R.id.stv1)
        var stv2 : TextView = itemView.findViewById(R.id.stv2)
        var stv3 : TextView = itemView.findViewById(R.id.stv3)
        var clRoot : ConstraintLayout  = itemView.findViewById(R.id.clRoot)

    }
    interface SocialInterface{
        fun onClick()
        fun onClickProfile()
        fun onClickPostDetails()
    }
}

