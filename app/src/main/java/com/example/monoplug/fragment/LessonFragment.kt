package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.databinding.FragmentLessonBinding


class LessonFragment : Fragment() {

    lateinit var binding : FragmentLessonBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_lesson, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnHire.setOnClickListener{
        findNavController().navigate(R.id.createLessonRequestFragment)
        }

    }
}