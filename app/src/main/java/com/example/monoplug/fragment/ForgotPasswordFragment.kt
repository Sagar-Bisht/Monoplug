package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.databinding.FragmentForgotPasswordBinding


class ForgotPasswordFragment : Fragment() {

    lateinit var binding : FragmentForgotPasswordBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_forgot_password, container, false)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.btnSend.root.setOnClickListener {
//            findNavController().navigate(R.id.forgotPasswordPopup)
//        }
        binding.btnSend.root.setOnClickListener {
            findNavController().navigate(R.id.forgotPasswordPopup)
        }
        binding.imgBack.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
    }
}