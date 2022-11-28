package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.RoomUsersAcceptedAdapter
import com.example.monoplug.databinding.FragmentRoomUsersAcceptedBinding
import com.example.monoplug.model.Accepted
import com.example.monoplug.model.RoomsMyInvitations


class RoomUsersAcceptedFragment : Fragment() {


    lateinit var binding : FragmentRoomUsersAcceptedBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_room_users_accepted, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

      var myAdapter = RoomUsersAcceptedAdapter(getList())
        binding.recViewPending.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recViewPending.adapter = myAdapter

    }
    fun getList() : List<Accepted> {
        var list = mutableListOf<Accepted>()
        for (i in 1..5) {
            list.add(
                Accepted(
                    R.drawable.invite_img,
                    "MJ96"
                )
            )
        }
        return list
    }
}