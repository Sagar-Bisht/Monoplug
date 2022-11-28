package com.example.monoplug.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monoplug.R
import com.example.monoplug.adapter.InviteAllAdapter
import com.example.monoplug.databinding.FragmentInviteAllBinding
import com.example.monoplug.model.InviteAll


class InviteAllFragment : Fragment() {

    lateinit var binding : FragmentInviteAllBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_invite_all, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myAdapter = InviteAllAdapter(getList())
        binding.recViewInviteAll.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL ,false)
        binding.recViewInviteAll.adapter = myAdapter


    }
    fun getList() : List<InviteAll> {
        var list = mutableListOf<InviteAll>()
        for (i in 1..10) {
            list.add(
                InviteAll(R.drawable.blogs_img,
                "John Doe",
                "Drummer",
                "\$250")
            )
        }
        return list
    }
}