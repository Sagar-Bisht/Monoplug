package com.example.monoplug.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.monoplug.R
import com.example.monoplug.baseDialogFragment.BaseDialogFragment
import com.example.monoplug.databinding.FilterDesignBinding
import com.example.monoplug.databinding.GiveRatingPopupBinding

class GiveRatingsPopup : BaseDialogFragment() {

    lateinit var binding: GiveRatingPopupBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.give_rating_popup, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
            dismiss()
        }

        binding.imgCancel.setOnClickListener {
            dismiss()
        }
    }
}