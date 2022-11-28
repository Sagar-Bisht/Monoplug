package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.RoomsMyInvitationsAdapter
import com.example.monoplug.databinding.FragmentRoomsMyInvitationsBinding
import com.example.monoplug.model.RoomsMyInvitations


class RoomsMyInvitationsFragment : Fragment() {


    lateinit var binding : FragmentRoomsMyInvitationsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_rooms_my_invitations, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var myAdapter = RoomsMyInvitationsAdapter(getList())
        binding.recViewInvitation.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recViewInvitation.adapter = myAdapter

    }
    fun getList() : List<RoomsMyInvitations> {
        var list = mutableListOf<RoomsMyInvitations>()
        for (i in 1..3) {
            list.add(
                RoomsMyInvitations(
                    "Discussion over Timing",
                    "25/01/2022 04:40 PM"
                )
            )
        }
        return list
    }
}