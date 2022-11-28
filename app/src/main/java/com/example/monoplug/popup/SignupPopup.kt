package com.example.monoplug.popup

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.monoplug.baseDialogFragment.BaseDialogFragment
import com.example.monoplug.R
import com.example.monoplug.databinding.SignupPopupBinding

class SignupPopup: BaseDialogFragment() {

    private lateinit var mBinding : SignupPopupBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

      // mBinding = SignupPopupBinding.inflate(inflater, container, false)
       mBinding= DataBindingUtil.inflate(inflater,R.layout.signup_popup,container,false)
        setUpUI()
        return mBinding.root

    }

    private fun setUpUI() {
        mBinding.btnOk.setOnClickListener{
            findNavController().navigate(R.id.loginFragment)
        }
        mBinding.imgCancel.setOnClickListener {
            dismiss()
        }
    }
    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)

    }
}
