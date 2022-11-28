package com.example.monoplug.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.activity.AuthActivity
import com.example.monoplug.activity.HomeActivity
import com.example.monoplug.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    lateinit var binding : FragmentSettingsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_settings, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.myProfile.root.setOnClickListener {
            findNavController().navigate(R.id.myProfileFragment)
        }
        binding.notification.root.setOnClickListener {
            findNavController().navigate(R.id.notificationsFragment)
        }
        binding.archived.root.setOnClickListener {
            findNavController().navigate(R.id.archivedFragment)
        }
        binding.howItWorks.root.setOnClickListener {
            findNavController().navigate(R.id.howItWorksFragment)
        }
        binding.contactsUs.root.setOnClickListener {
            findNavController().navigate(R.id.contactUsFragment)
        }
        binding.changePassword.root.setOnClickListener {
            findNavController().navigate(R.id.changePasswordFragment)
        }
        binding.logout.root.setOnClickListener {
         findNavController().navigate(R.id.logoutPopup)
        }

    }
}