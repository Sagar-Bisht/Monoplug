package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.adapter.VPagerAdapterForUserProfile
import com.example.monoplug.databinding.FragmentUserProfileBinding


class UserProfileFragment : Fragment() {

    lateinit var binding : FragmentUserProfileBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_user_profile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var userProfileAdapter = VPagerAdapterForUserProfile(requireContext(),childFragmentManager)
        binding.viewPager.adapter=userProfileAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)


        binding.appCompatButton.setOnClickListener{
            findNavController().navigate(R.id.artistProfileFragment )
        }

    }
}