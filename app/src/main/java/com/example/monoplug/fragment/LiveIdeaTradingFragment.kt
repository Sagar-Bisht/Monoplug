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
import com.example.monoplug.adapter.LiveIdeaTradingAdapter
import com.example.monoplug.databinding.FragmentLiveIdeaTradingBinding
import com.example.monoplug.model.LiveIdeaTrading


class LiveIdeaTradingFragment : Fragment() {


    lateinit var binding : FragmentLiveIdeaTradingBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_live_idea_trading, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.floatingBtn.setOnClickListener {
            findNavController().navigate(R.id.createIdeaTradingSessionFragment)
        }

        var myAdapter = LiveIdeaTradingAdapter(getList())
        binding.recViewIdeaTrading.layoutManager=
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
        binding.recViewIdeaTrading.adapter=myAdapter
    }

    fun getList() : List<LiveIdeaTrading> {
        var list = mutableListOf<LiveIdeaTrading>()
        for (i in 1..4) {
            list.add(
                LiveIdeaTrading(
                    "Discussion over improve\n" +
                            "ment points in an event",
                    "25/01/2022 04:40 PM"
                )
            )
        }
        return list
    }

}