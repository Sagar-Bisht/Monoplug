package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.InviteTwoAdapter
import com.example.monoplug.databinding.FragmentInviteTwoBinding
import com.example.monoplug.model.InviteTwo


class InviteTwoFragment : Fragment() {


    lateinit var binding : FragmentInviteTwoBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_invite_two, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        var myAdapter = InviteTwoAdapter(getList())
        binding.recViewInvite.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recViewInvite.adapter = myAdapter

    }
    fun getList() : List<InviteTwo> {
        var list = mutableListOf<InviteTwo>()
        for (i in 1..10) {
            list.add(
                InviteTwo(
                    R.drawable.invite_img,
                    "MJ96"
                )
            )
        }
        return list
    }
}