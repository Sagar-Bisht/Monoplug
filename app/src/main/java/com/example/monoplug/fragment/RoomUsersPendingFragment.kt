package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.RoomUsersPendingAdapter
import com.example.monoplug.databinding.FragmentRoomUsersPendingBinding
import com.example.monoplug.model.Pending
import com.example.monoplug.model.RoomsMyInvitations


class RoomUsersPendingFragment : Fragment() {


    lateinit var binding : FragmentRoomUsersPendingBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_room_users_pending, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var myAdapter = RoomUsersPendingAdapter(getList())
        binding.recViewPending.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recViewPending.adapter = myAdapter

    }
    fun getList() : List<Pending> {
        var list = mutableListOf<Pending>()
        for (i in 1..5) {
            list.add(
                Pending(
                    R.drawable.invite_img,
                    "MJ96"
                )
            )
        }
        return list
    }
}