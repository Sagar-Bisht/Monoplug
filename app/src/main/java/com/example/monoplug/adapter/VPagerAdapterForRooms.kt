package com.example.monoplug.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.monoplug.fragment.*


class VPagerAdapterForRooms(context: Context, fm: FragmentManager) : FragmentPagerAdapter(fm) {

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
               MyRoomsFragment()
            }
            else -> {
               RoomsMyInvitationsFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "My Rooms"
            1 -> "My Invitations"
            else -> null
        }
    }
}