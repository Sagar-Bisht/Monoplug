package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.databinding.FragmentChooseOptionBinding


class ChooseOptionFragment : Fragment() {

    lateinit var binding : FragmentChooseOptionBinding
    lateinit var navController : NavController
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_choose_option, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnUser.root.setOnClickListener {
            findNavController().navigate(R.id.signupFragment)
        }

        binding.tvAlready.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }



    }
}