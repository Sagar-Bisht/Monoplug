package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.adapter.VPagerAdapterForArtistProfile
import com.example.monoplug.databinding.FragmentArtistProfileBinding

class ArtistProfileFragment : Fragment() {

    lateinit var binding : FragmentArtistProfileBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_artist_profile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var artistProfileAdapter = VPagerAdapterForArtistProfile(requireContext(),childFragmentManager)
        binding.viewPager.adapter=artistProfileAdapter

        binding.tabLayout.setupWithViewPager(binding.viewPager)

        binding.tvLessonDetails.setOnClickListener {
            findNavController().navigate(R.id.lessonFragment)
        }
        binding.tvBehindTheScene.setOnClickListener {
            findNavController().navigate(R.id.behindTheScenesFragment)
        }


    }
}