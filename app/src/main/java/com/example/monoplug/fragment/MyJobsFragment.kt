package com.example.monoplug.fragment

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.monoplug.R
import com.example.monoplug.adapter.VPagerAdapterForMyJobs
import com.example.monoplug.databinding.FragmentMyJobsBinding


class MyJobsFragment : Fragment() {

    lateinit var binding : FragmentMyJobsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding.tabLayout.getTabAt(0)?.select()

        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_my_jobs, container, false)
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

        var myJobsAdapter = VPagerAdapterForMyJobs(requireContext(),childFragmentManager)
        binding.viewPager.adapter=myJobsAdapter
        binding.tabLayout.setupWithViewPager(binding.viewPager)


        binding.floatingBtn.setOnClickListener {
            findNavController().navigate(R.id.createJobFragment)
        }
    }
}