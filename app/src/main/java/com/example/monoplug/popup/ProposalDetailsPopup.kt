package com.example.monoplug.popup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.baseDialogFragment.BaseDialogFragment
import com.example.monoplug.databinding.ProposalDetailsPopupBinding

class ProposalDetailsPopup : BaseDialogFragment() {

    lateinit var binding: ProposalDetailsPopupBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.proposal_details_popup, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSubmit.setOnClickListener {
           findNavController().navigate(R.id.jobDetails2Fragment)
        }
        binding.imgCancel.setOnClickListener {
            dismiss()
        }
    }
}