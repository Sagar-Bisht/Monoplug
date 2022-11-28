package com.example.monoplug.fragment

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.monoplug.R
import com.example.monoplug.adapter.ViewPagerAdapter
import com.example.monoplug.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {


    lateinit var  binding : FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_home, container, false)
        val linearLayout = binding.tabLayout.getChildAt(0) as LinearLayout
        linearLayout.showDividers = LinearLayout.SHOW_DIVIDER_MIDDLE
        val drawable = GradientDrawable()
        drawable.setColor(resources.getColor(R.color.tab_line))
        drawable.setSize(2, 2)
        linearLayout.dividerPadding = 1
        linearLayout.dividerDrawable = drawable
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var viewPager = binding.viewPager
        var adapter  = ViewPagerAdapter(requireContext(),childFragmentManager)
        viewPager.adapter = adapter
        binding.tabLayout.setupWithViewPager(viewPager)


    }
}