package com.example.monoplug.fragment

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import com.example.monoplug.R
import com.example.monoplug.adapter.VPagerAdapterForLive
import com.example.monoplug.databinding.FragmentLiveBinding


class LiveFragment : Fragment() {

    lateinit var binding: FragmentLiveBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_live, container, false)

        val linearLayout = binding.tabLayout.getChildAt(0) as LinearLayout
        linearLayout.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
        val drawable = GradientDrawable()
        drawable.setColor(resources.getColor(R.color.tab_line))
        drawable.setSize(1, 1)
        linearLayout.dividerPadding = 1
        linearLayout.dividerDrawable = drawable

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var myLiveAdapter = VPagerAdapterForLive(requireContext(),childFragmentManager)
        binding.viewPager.adapter = myLiveAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)
    }
}