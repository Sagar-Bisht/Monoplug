package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.ArchivedAdapter
import com.example.monoplug.databinding.FragmentArchivedBinding
import com.example.monoplug.model.Archived


class ArchivedFragment : Fragment() {


    lateinit var binding : FragmentArchivedBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_archived, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var myAdapter = ArchivedAdapter(getList())
        binding.recViewArchived.layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        binding.recViewArchived.adapter=myAdapter


    }
    fun getList() : List<Archived>{
        var list = mutableListOf<Archived>()
        for(i in 1..10){
            list.add(Archived("28/01/2022 10:50 AM","London"))
        }
        return list
    }

}