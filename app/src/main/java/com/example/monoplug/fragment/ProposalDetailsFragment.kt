package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.databinding.FragmentProposalDetailsBinding


class ProposalDetailsFragment : Fragment() {

    lateinit var binding : FragmentProposalDetailsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_proposal_details, container, false)
        
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAccept.root.setOnClickListener {
            findNavController().navigate(R.id.proposalDetails2Fragment)
        }
        binding.btnReject.root.setOnClickListener {
            findNavController().navigate(R.id.jobDetailsFragment)
        }

}

}