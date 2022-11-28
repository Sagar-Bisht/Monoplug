package com.example.monoplug.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.monoplug.fragment.*


class VPagerAdapterForRoomUsers(context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val mContext: Context

    init {
        mContext = context
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
               RoomUsersPendingFragment()
            }
            else -> {
                RoomUsersAcceptedFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Pending"
            1 -> "Accepted"
            else -> null
        }
    }
}