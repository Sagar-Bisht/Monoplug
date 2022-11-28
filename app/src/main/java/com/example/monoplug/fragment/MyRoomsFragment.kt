package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.MyRoomsAdapter
import com.example.monoplug.databinding.FragmentMyRoomsBinding
import com.example.monoplug.model.MyRooms


class MyRoomsFragment : Fragment() , MyRoomsAdapter.BtnViewUserClick {


    lateinit var binding : FragmentMyRoomsBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_my_rooms, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var myAdapter = MyRoomsAdapter(getList(), this)
        binding.recViewMYRooms.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recViewMYRooms.adapter = myAdapter

    }
    fun getList() : List<MyRooms> {
        var list = mutableListOf<MyRooms>()
        for (i in 1..3) {
            list.add(
                MyRooms(
                    "Discussion over Timing",
                    "25/01/2022 04:40 PM"
                    )
            )
        }
        return list
    }

    override fun onClick() {
       findNavController().navigate(R.id.roomUsersFragment)
    }
}