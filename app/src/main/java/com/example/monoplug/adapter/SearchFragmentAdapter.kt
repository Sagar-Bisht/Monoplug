package com.example.monoplug.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.monoplug.R
import com.example.monoplug.model.Search

class SearchFragmentAdapter(var list : List<Search>, private val searchListenerClick :SearchListenerClick ) : RecyclerView.Adapter<SearchFragmentAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       var view = LayoutInflater.from(parent.context).inflate(R.layout.search_fragment_design,parent,false)
        return MyViewHolder(view)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var p = list[position]
        holder.imgSearch.setImageResource(p.imgSearch)
        holder.tvSearch.text=p.tvSearch
        holder.btnViewProfile.setOnClickListener{
            searchListenerClick.viewProfileClick()
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgSearch : ImageView = itemView.findViewById(R.id.imgSearch)
        var tvSearch : TextView = itemView.findViewById(R.id.tvSearch)
        var btnViewProfile: Button = itemView.findViewById(R.id.btnViewProfile)
    }

    interface SearchListenerClick{
        fun  viewProfileClick()
    }

}