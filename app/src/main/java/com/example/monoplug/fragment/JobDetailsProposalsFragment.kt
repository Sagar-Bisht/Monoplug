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
import com.example.monoplug.adapter.JobDetailsProposalsAdapter
import com.example.monoplug.databinding.FragmentJobDetailsProposalsBinding
import com.example.monoplug.model.JobDetailsProposals


class JobDetailsProposalsFragment : Fragment() , JobDetailsProposalsAdapter.ClickClProposal{

    lateinit var binding : FragmentJobDetailsProposalsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_job_details_proposals, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = JobDetailsProposalsAdapter(getList() , this)
        binding.recViewProposal.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)
        binding.recViewProposal.adapter = myAdapter

    }
    fun getList() : List<JobDetailsProposals> {
        var list = mutableListOf<JobDetailsProposals>()
        for (i in 1..10) {
            list.add(
                JobDetailsProposals(R.drawable.invite_img,
                    "John Doe",
                    "Drummer",
                    "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's" +
                            " standard dummy text ever since the 1500s," +
                            " when an unknown printer took a galley of type and scrambled it to make a type specimen book.")
            )
        }
        return list
    }

    override fun onClick() {
        findNavController().navigate(R.id.proposalDetailsFragment)
    }

}