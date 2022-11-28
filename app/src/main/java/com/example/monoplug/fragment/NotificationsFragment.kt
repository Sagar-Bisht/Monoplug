package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.NotificationsAdapter
import com.example.monoplug.databinding.FragmentNotificationsBinding
import com.example.monoplug.model.Notifications


class NotificationsFragment : Fragment() {

    lateinit var binding : FragmentNotificationsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_notifications, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val myAdapter = NotificationsAdapter(getList())
//        binding.recViewNoti.layoutManager=
//            LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
//        binding.recViewNoti.adapter= myAdapter



    }
    fun getList() : List<Notifications>{
        var list = mutableListOf<Notifications>()
        for(i in 1..4) {
            list.add(Notifications("Job Title", "25/01/2022 4:40 PM", "This job is completed."))
        }
        return list
    }

}