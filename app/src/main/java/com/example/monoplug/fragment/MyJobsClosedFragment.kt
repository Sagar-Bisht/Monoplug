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
import com.example.monoplug.adapter.MyJobsClosedAdapter
import com.example.monoplug.databinding.FragmentMyJobsClosedBinding
import com.example.monoplug.model.MyJobsClosed


class MyJobsClosedFragment : Fragment() , MyJobsClosedAdapter.OnClosedClick {

    lateinit var binding : FragmentMyJobsClosedBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_jobs_closed, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = MyJobsClosedAdapter(getList() , this)
        binding.recViewClosed.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recViewClosed.adapter = myAdapter

    }

    fun getList(): List<MyJobsClosed> {
        var list = mutableListOf<MyJobsClosed>()
        for (i in 1..10) {
            list.add(
                MyJobsClosed(
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

    override fun onClick() {
       findNavController().navigate(R.id.jobDetails3Fragment)
    }
}