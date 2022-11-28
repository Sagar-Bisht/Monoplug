package com.example.monoplug.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.monoplug.fragment.*


class VPagerAdapterForLive(context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

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
                LiveLessonFragment()
            }
            1->{
                LiveOpenMicFragment()
            }
            else -> {
                LiveIdeaTradingFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Lesson"
            1 -> "Open Mic Forums"
            2 -> "Idea Trading"
            else -> null
        }
    }
}