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
import com.example.monoplug.adapter.JobDetailsInvitedAdapter
import com.example.monoplug.adapter.JobDetailsProposalsAdapter
import com.example.monoplug.databinding.FragmentJobDetailsInvitedBinding
import com.example.monoplug.model.JobDetailsInvited
import com.example.monoplug.model.JobDetailsProposals

class JobDetailsInvitedFragment : Fragment() {


    lateinit var binding : FragmentJobDetailsInvitedBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_job_details_invited, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = JobDetailsInvitedAdapter(getList())
        binding.recViewInvited.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)
        binding.recViewInvited.adapter = myAdapter

        // navigate to invite fragment
        binding.floatingBtn.setOnClickListener {
            findNavController().navigate(R.id.inviteFragment)
        }
    }

    fun getList() : List<JobDetailsInvited> {
        var list = mutableListOf<JobDetailsInvited>()
        for (i in 1..10) {
            list.add(
                JobDetailsInvited(R.drawable.invite_img,
                    "John Doe",
                    "Drummer"
                )
            )
        }
        return list
    }
}