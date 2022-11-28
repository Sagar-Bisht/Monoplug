package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.monoplug.R
import com.example.monoplug.adapter.VPagerAdapterForJobDetails
import com.example.monoplug.databinding.FragmentJobDetailsBinding

class JobDetailsFragment : Fragment() {

    lateinit var binding : FragmentJobDetailsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_job_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var artistProfileAdapter = VPagerAdapterForJobDetails(requireContext(),childFragmentManager)
        binding.viewPager.adapter=artistProfileAdapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }

}