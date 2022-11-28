package com.example.monoplug.baseDialogFragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import com.example.monoplug.R

abstract class BaseDialogFragment : DialogFragment() {

    var dialogg: Dialog? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        dialogg = super.onCreateDialog(savedInstanceState)

        dialogg?.setCanceledOnTouchOutside(false)
      //  dialogg?.window?.setBackgroundDrawableResource(R.drawable.view_border_design)
        dialogg?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.MATCH_PARENT
        dialogg!!.window?.setLayout(width,height)
        dialogg!!.window?.setGravity(Gravity.CENTER)
        dialogg!!.window?.setDimAmount(.8f)
        dialogg!!.window?.addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        dialogg!!.window?.statusBarColor=requireContext().resources.getColor(R.color.white)

        return dialogg!!
    }
    protected open fun onDialogSlide(bottomSheet: View, slideOffset: Float) {}
}