package com.example.monoplug.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.monoplug.fragment.*


class VPagerAdapterForMyJobs(context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val mContext: Context

    init {
        mContext = context
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                MyJobsActiveFragment()
            }
            1->{
                MyJobsPendingFragment()
            }
            else -> {
                MyJobsClosedFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Active"
            1 -> "Pending"
            2 -> "Closed"
            else -> null
        }
    }
}