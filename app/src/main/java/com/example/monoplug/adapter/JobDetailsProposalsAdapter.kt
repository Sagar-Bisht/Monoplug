package com.example.monoplug.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.monoplug.R
import com.example.monoplug.model.JobDetailsProposals

class JobDetailsProposalsAdapter(var list : List<JobDetailsProposals> , val clickProposal : ClickClProposal) : RecyclerView.Adapter<JobDetailsProposalsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.job_details_proposal_design,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var itemPosition = list[position]
        holder.img.setImageResource(itemPosition.img)
        holder.tv1.text=itemPosition.tv1
        holder.tv2.text=itemPosition.tv2
        holder.tv3.text=itemPosition.tv3
        holder.clProposal.setOnClickListener {
            clickProposal.onClick()
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
        var clProposal : ConstraintLayout = itemView.findViewById(R.id.clProposal)
    }
    interface ClickClProposal{
        fun onClick()
    }
}

