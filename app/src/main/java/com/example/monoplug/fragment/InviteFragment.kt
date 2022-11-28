package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.adapter.VPagerAdapterForInvite
import com.example.monoplug.databinding.FragmentInviteBinding


class InviteFragment : Fragment() {

    lateinit var binding : FragmentInviteBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_invite, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var myJobsAdapter = VPagerAdapterForInvite(requireContext(),childFragmentManager)
        binding.viewPager.adapter=myJobsAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.btnSubmit.root.setOnClickListener {
            findNavController().navigate(R.id.myJobsFragment)
        }

    }
}