package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.LiveOpenMicAdapter
import com.example.monoplug.databinding.FragmentLiveOpenMicBinding
import com.example.monoplug.model.LiveOpenMic


class LiveOpenMicFragment : Fragment() {


    lateinit var binding : FragmentLiveOpenMicBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_live_open_mic, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tv.setOnClickListener {
            findNavController().navigate(R.id.roomsFragment)
        }

        binding.floatingBtn.setOnClickListener {
            findNavController().navigate(R.id.createRoomFragment)
        }

    var myAdapter = LiveOpenMicAdapter(getList())
    binding.recViewOpenMic.layoutManager=
        LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
    binding.recViewOpenMic.adapter=myAdapter
}

fun getList() : List<LiveOpenMic> {
    var list = mutableListOf<LiveOpenMic>()
    for (i in 1..4) {
        list.add(
            LiveOpenMic(
                "Discussion over Timing",
                "25/01/2022 04:40 PM"
               )
        )
    }
    return list
}
}