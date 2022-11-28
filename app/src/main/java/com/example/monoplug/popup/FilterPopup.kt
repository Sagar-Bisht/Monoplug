package com.example.monoplug.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.monoplug.R
import com.example.monoplug.baseDialogFragment.BaseDialogFragment
import com.example.monoplug.databinding.FilterDesignBinding

class FilterPopup : BaseDialogFragment() {

    lateinit var binding: FilterDesignBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.filter_design, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            dismiss()
        }
        binding.btnReset.setOnClickListener {
            dismiss()
        }
        binding.imgCancel.setOnClickListener {
            dismiss()
        }
    }
}