package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.monoplug.R
import com.example.monoplug.adapter.VPagerAdapterForRoomUsers
import com.example.monoplug.databinding.FragmentRoomUsersBinding


class RoomUsersFragment : Fragment() {


    lateinit var binding : FragmentRoomUsersBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_room_users, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var vPagerAdapter = VPagerAdapterForRoomUsers(requireContext(),childFragmentManager)
        binding.viewPager.adapter=vPagerAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)

    }

}