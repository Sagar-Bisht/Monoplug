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
import com.example.monoplug.model.Message

class MessageAdapter(var list : List<Message> , val msgClick : MsgClick ) : RecyclerView.Adapter<MessageAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.message_fragment_design,parent,false)
        return MyViewHolder(view)
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var itemPosition = list[position]
        holder.tv1.text=itemPosition.tv1
        holder.tv2.text=itemPosition.tv2
        holder.tv3.text=itemPosition.tv3
        holder.clMessage.setOnClickListener {
            msgClick.onClick()
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var img : ImageView =itemView.findViewById(R.id.img)
        var tv1 : TextView = itemView.findViewById(R.id.tv1)
        var tv2 : TextView = itemView.findViewById(R.id.tv2)
        var tv3 : TextView = itemView.findViewById(R.id.tv3)
        var clMessage : ConstraintLayout = itemView.findViewById(R.id.clMessage)

    }

    interface MsgClick{
        fun onClick()
    }
}

