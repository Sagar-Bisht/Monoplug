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
import com.example.monoplug.adapter.MyJobsPendingAdapter
import com.example.monoplug.databinding.FragmentMyJobsPendingBinding
import com.example.monoplug.model.MyJobsPending


class MyJobsPendingFragment : Fragment() , MyJobsPendingAdapter.OnPendingClick {


    lateinit var binding : FragmentMyJobsPendingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_jobs_pending, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = MyJobsPendingAdapter(getList(),this)
        binding.recViewPending.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recViewPending.adapter = myAdapter
    }

    fun getList(): List<MyJobsPending> {
        var list = mutableListOf<MyJobsPending>()
        for (i in 1..10) {
            list.add(
                MyJobsPending(
                    "Job of Dancers",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                            " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                            " when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                    "25/01/2022 04:40 PM",
                    "See Details"
                )
            )
        }
        return list
    }

    override fun onClick() {
        findNavController().navigate(R.id.jobDetailsFragment)
    }

}