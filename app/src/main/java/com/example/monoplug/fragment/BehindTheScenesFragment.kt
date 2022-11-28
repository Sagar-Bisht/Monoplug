package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.databinding.FragmentBehindTheScenesBinding


class BehindTheScenesFragment : Fragment() {

    lateinit var binding: FragmentBehindTheScenesBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_behind_the_scenes, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cl1.setOnClickListener {
            findNavController().navigate(R.id.behindTheScenesTwoFragment)
        }
        binding.cl2.setOnClickListener {
            findNavController().navigate(R.id.behindTheScenesTwoFragment)
        }
        binding.cl3.setOnClickListener {
            findNavController().navigate(R.id.behindTheScenesTwoFragment)
        }
        binding.cl4.setOnClickListener {
            findNavController().navigate(R.id.behindTheScenesTwoFragment)
        }
    }
}