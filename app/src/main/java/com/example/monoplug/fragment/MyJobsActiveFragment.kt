package com.example.monoplug.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.MyJobsActiveAdapter
import com.example.monoplug.databinding.FragmentMyJobsActiveBinding
import com.example.monoplug.model.MyJobsActive


class MyJobsActiveFragment : Fragment() , MyJobsActiveAdapter.MyJobClickListener {


    lateinit var binding: FragmentMyJobsActiveBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_my_jobs_active, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = MyJobsActiveAdapter(getList() , this)
        binding.recViewActive.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recViewActive.adapter = myAdapter
    }

    fun getList(): List<MyJobsActive> {
        var list = mutableListOf<MyJobsActive>()
        for (i in 1..10) {
            list.add(
                MyJobsActive(
                    "Job of Dancers",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
                            " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s," +
                            " when an unknown printer took a galley of type and scrambled it to make a type specimen book.",
                    "Artist Name",
                    "\$120",
                    "25/01/2022 04:40 PM",
                    "See Details"
                )
            )
        }
        return list
    }

    override fun onActiveClick() {
        findNavController().navigate(R.id.jobDetails2Fragment)
    }
}