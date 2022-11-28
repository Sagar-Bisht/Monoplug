package com.example.monoplug.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.monoplug.fragment.HomeBlogsFragment
import com.example.monoplug.fragment.HomeNewsFragment
import com.example.monoplug.fragment.HomeStoriesFragment


class ViewPagerAdapter(context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

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
                HomeStoriesFragment()
            }
            1 -> {
                HomeNewsFragment()
            }
            else -> {
                HomeBlogsFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Stories"
            1 -> "News"
            2 -> "Blogs"
            else -> null
        }
    }
}
