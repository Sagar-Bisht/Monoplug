package com.example.monoplug.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.monoplug.R
import com.example.monoplug.model.MyJobsActive

class MyJobsActiveAdapter(var list : List<MyJobsActive> , val myJobClickListener : MyJobClickListener ) : RecyclerView.Adapter<MyJobsActiveAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.my_jobs_active_design,parent,false)
        return MyViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var itemPosition = list[position]
        holder.tv1.text=itemPosition.tv1
        holder.tv2.text=itemPosition.tv2
        holder.tv3.text=itemPosition.tv3
        holder.tv4.text=itemPosition.tv4
        holder.tv5.text=itemPosition.tv5
        holder.tv6.text=itemPosition.tv6
        holder.clRoot.setOnClickListener{
            myJobClickListener.onActiveClick()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv1 : TextView = itemView.findViewById(R.id.tv1)
        var tv2 : TextView = itemView.findViewById(R.id.tv2)
        var tv3 : TextView = itemView.findViewById(R.id.tv3)
        var tv4 : TextView = itemView.findViewById(R.id.tv4)
        var tv5 : TextView = itemView.findViewById(R.id.tv5)
        var tv6 : TextView = itemView.findViewById(R.id.tvLessonDetails)
        var clRoot : ConstraintLayout = itemView.findViewById(R.id.clRoot)

    }
    interface MyJobClickListener{
        fun onActiveClick()
    }
}

