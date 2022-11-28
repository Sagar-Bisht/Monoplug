package com.example.monoplug.popup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.monoplug.R
import com.example.monoplug.activity.AuthActivity
import com.example.monoplug.activity.HomeActivity
import com.example.monoplug.baseDialogFragment.BaseDialogFragment
import com.example.monoplug.databinding.LogoutPopBinding

class LogoutPopup : BaseDialogFragment() {

    lateinit var binding: LogoutPopBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.logout_pop, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNo.setOnClickListener {
            dismiss()
        }
        binding.btnYes.setOnClickListener {
            var intent = Intent(requireActivity(), AuthActivity::class.java)
            (requireActivity() as HomeActivity).startActivity(intent)
            requireActivity().finish()
        }
        binding.imgCancel.setOnClickListener {
            dismiss()
        }
    }
}